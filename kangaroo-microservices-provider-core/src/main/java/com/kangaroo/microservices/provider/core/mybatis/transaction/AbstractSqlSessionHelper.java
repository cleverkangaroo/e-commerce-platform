package com.kangaroo.microservices.provider.core.mybatis.transaction;

import java.util.Collection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import tk.mybatis.mapper.common.Mapper;

public abstract class AbstractSqlSessionHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractSqlSessionHelper.class);
	
	protected abstract SqlSessionFactory getSqlSessionFactory();
	protected abstract SqlSessionTemplate getSqlSessionTemplate();
	protected abstract DataSourceTransactionManager getTxManager();


	public <T> T getMapper(Class<T> mapperClass, SqlSession sqlSession) {
		return sqlSession.getMapper(mapperClass);
	}
	

	public void execute(Callback cb) {
		execute(true, cb);
	}
	

	public void execute(Boolean autoCommit, Callback cb) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(autoCommit);
		try {
			DaoHelper helper = new DaoHelper(sqlSession);
			cb.invoke(helper);
			if (!autoCommit) {
				// 非自动提交，在callback执行完成后提交整个事务
				sqlSession.commit();
				sqlSession.clearCache();
			}
		} catch (Throwable t) {
			// 异常
			sqlSession.rollback();
			sqlSession.clearCache();
		}
		sqlSession.close();
	}
	

	public <T> boolean batchSave(Class<? extends Mapper<T>> mapperClass, Collection<T> saveDataList) {
		SqlSession sqlSession = getSqlSessionTemplate().getSqlSessionFactory().openSession(ExecutorType.BATCH, Boolean.FALSE);
		Mapper<T> mapper = sqlSession.getMapper(mapperClass);
		Integer index = 0;
		try {
			if (saveDataList != null && !saveDataList.isEmpty()) {
				for (T t : saveDataList) {
					mapper.insertSelective(t);
					index ++;
				}
				
				sqlSession.commit();
				sqlSession.clearCache();
				
			} else {
				LOG.info("批量更新数据列表为空");
			}
			
		} catch (Exception e) {
			LOG.error("第" + (index + 1) + "条数据增加失败", e);
			sqlSession.rollback();
			sqlSession.clearCache();
			
			return false;
		} finally {
			sqlSession.close();
		}
		
		return true;
	}
	

	public <T> boolean batchUpdate(Class<? extends Mapper<T>> mapperClass, Collection<T> updateDataList) {
		SqlSession sqlSession = getSqlSessionTemplate().getSqlSessionFactory().openSession(ExecutorType.BATCH, Boolean.FALSE);
		Mapper<T> mapper = sqlSession.getMapper(mapperClass);
		Integer index = 0;
		try {
			if (updateDataList != null && !updateDataList.isEmpty()) {
				for (T t : updateDataList) {
					mapper.updateByPrimaryKeySelective(t);
					index ++;
				}
				
				sqlSession.commit();
				sqlSession.clearCache();
				
			} else {
				LOG.info("批量更新数据列表为空");
			}
			
		} catch (Exception e) {
			LOG.error("第" + (index + 1) + "条数据更新失败", e);
			sqlSession.rollback();
			sqlSession.clearCache();
			
			return false;
		} finally {
			sqlSession.close();
		}
		
		return true;
	}
	

	public interface Callback {
		public void invoke(DaoHelper helper);
	}
	

	public class DaoHelper {
		private SqlSession sqlSession;
		public DaoHelper(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
		}
		
		public <T> T getMapper(Class<T> mapperClass) {
			return sqlSession.getMapper(mapperClass);
		}
		
		public void rollback() {
			sqlSession.rollback();
			sqlSession.clearCache();
		}
	}
	
}