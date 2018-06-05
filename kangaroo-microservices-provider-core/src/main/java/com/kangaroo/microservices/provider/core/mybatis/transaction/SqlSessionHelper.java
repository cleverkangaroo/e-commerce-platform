package com.kangaroo.microservices.provider.core.mybatis.transaction;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kangaroo.microservices.provider.core.mybatis.transaction.AbstractSqlSessionHelper.DaoHelper;


@Component
public class SqlSessionHelper {

	private static MasterSqlSessionHelper masterSqlSessionHelper;
	private static BusinessSqlSessionHelper businessSqlSessionHelper;

	@Autowired(required = true)
	public void setMasterSqlSessionTemplate(MasterSqlSessionHelper masterSqlSessionHelper) {
		SqlSessionHelper.masterSqlSessionHelper = masterSqlSessionHelper;
	}

	@Autowired(required = true)
	public void setBusinessSqlSessionTemplate(BusinessSqlSessionHelper businessSqlSessionHelper) {
		SqlSessionHelper.businessSqlSessionHelper = businessSqlSessionHelper;
	}

	public static MasterSqlSessionHelper getMasterSqlSessionHelper() {
		return SqlSessionHelper.masterSqlSessionHelper;
	}

	public static BusinessSqlSessionHelper getBusinessSqlSessionHelper() {
		return SqlSessionHelper.businessSqlSessionHelper;
	}

	public static <T> T execute(Callback<T> cb) throws Exception {
		return execute(true, cb);
	}

	public static <T> T execute(boolean autoCommit, Callback<T> cb) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		SqlSessionFactory masterSqlSessionFactory = masterSqlSessionHelper.getSqlSessionFactory();
		SqlSessionFactory businessSqlSessionFactory = businessSqlSessionHelper.getSqlSessionFactory();

		TransactionStatus masterStatus = masterSqlSessionHelper.getTxManager().getTransaction(def);
		TransactionStatus businessStatus = businessSqlSessionHelper.getTxManager().getTransaction(def);

		SqlSession masterSqlSession = masterSqlSessionFactory.openSession();
		SqlSession businessSqlSession = businessSqlSessionFactory.openSession();
		DaoHelper masterDaoHelper = masterSqlSessionHelper.new DaoHelper(masterSqlSession);
		DaoHelper businessDaoHelper = businessSqlSessionHelper.new DaoHelper(businessSqlSession);

		T result = null;
		try {
			result = cb.invoke(masterDaoHelper, businessDaoHelper);
		} catch (Throwable t) {
			masterStatus.setRollbackOnly();
			businessStatus.setRollbackOnly();
		} finally {
			masterSqlSessionHelper.getTxManager().commit(masterStatus);
			businessSqlSessionHelper.getTxManager().commit(businessStatus);

			masterSqlSession.clearCache();
			businessSqlSession.clearCache();

			masterSqlSession.close();
			businessSqlSession.close();
		}

		return result;
	}

	public interface Callback<T> {
		public T invoke(DaoHelper masterDaoHelper, DaoHelper businessDaoHelper);
	}
}
