package com.kangaroo.microservices.provider.core.mybatis.transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

@Component("masterSqlSessionHelper")
public class MasterSqlSessionHelper extends AbstractSqlSessionHelper {

	private final SqlSessionTemplate sqlSessionTemplate;
	private final DataSourceTransactionManager dataSourceTransactionManager;

	@Autowired
	public MasterSqlSessionHelper(@Qualifier("masterSqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate,
			@Qualifier(TransactionConstant.MASTER) DataSourceTransactionManager dataSourceTransactionManager) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}

	@Override
	public SqlSessionFactory getSqlSessionFactory() {
		return this.sqlSessionTemplate.getSqlSessionFactory();
	}

	@Override
	protected SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	@Override
	protected DataSourceTransactionManager getTxManager() {
		return this.dataSourceTransactionManager;
	}

}