package com.kangaroo.microservices.provider.core.mybatis.transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

//@Component("businessSqlSessionHelper")
public class BusinessSqlSessionHelper extends AbstractSqlSessionHelper {

	private final SqlSessionTemplate sqlSessionTemplate;
	private final DataSourceTransactionManager dataSourceTransactionManager;

	@Autowired
	public BusinessSqlSessionHelper(@Qualifier("businessSqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate,
			@Qualifier(MultiTransactionConstant.BUSINESS) DataSourceTransactionManager dataSourceTransactionManager) {
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
