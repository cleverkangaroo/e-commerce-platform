package com.kangaroo.microservices.provider.core.mybatis.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageInterceptor;
import com.kangaroo.microservices.provider.core.mybatis.transaction.MultiTransactionConstant;

//@Configuration
//@EnableTransactionManagement
public class MultiDataMyBatisConfiguration implements TransactionManagementConfigurer {

	@Autowired
	DataSource businessDataSource;

	@Resource(name = "masterDataSource")
	DataSource masterDataSource;

	@Bean(name = "masterSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(masterDataSource);
		sfb.setTypeAliasesPackage("com.kangaroo.microservices.provider.*.model");
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setLogImpl(Slf4jImpl.class);
		sfb.setConfiguration(config);

		// 分页插件
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "false");
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		properties.setProperty("autoRuntimeDialect", "true");
		pageInterceptor.setProperties(properties);

		// 添加插件
		sfb.setPlugins(new Interceptor[] { pageInterceptor });

		return sfb.getObject();
	}

	@Bean(name = "masterSqlSessionTemplate")
	public SqlSessionTemplate masterSqlSessionTemplate(
			@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = MultiTransactionConstant.MASTER)
	public DataSourceTransactionManager masterDataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(masterDataSource);
		dataSourceTransactionManager.setNestedTransactionAllowed(true);
		return dataSourceTransactionManager;
	}

	@Bean(name = "businessSqlSessionFactory")
	public SqlSessionFactory businessSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(businessDataSource);
		sfb.setTypeAliasesPackage("com.kangaroo.microservices.provider.*.model");
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setLogImpl(Slf4jImpl.class);
		sfb.setConfiguration(config);

		// 分页插件
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "false");
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		properties.setProperty("autoRuntimeDialect", "true");
		pageInterceptor.setProperties(properties);

		// 添加插件
		sfb.setPlugins(new Interceptor[] { pageInterceptor });

		return sfb.getObject();
	}

	@Bean(name = "businessSqlSessionTemplate")
	public SqlSessionTemplate businessSqlSessionTemplate(
			@Qualifier("businessSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = MultiTransactionConstant.BUSINESS)
	public DataSourceTransactionManager businessDataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(businessDataSource);
		dataSourceTransactionManager.setNestedTransactionAllowed(true);
		return dataSourceTransactionManager;
	}

	@Primary
	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return businessDataSourceTransactionManager();
	}

}