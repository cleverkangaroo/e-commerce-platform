package com.kangaroo.microservices.provider.base.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.kangaroo.microservices.provider.core.druid.multids.BaseDataSourceProperties;
import com.kangaroo.microservices.provider.core.druid.support.DecryptDruidDataSource;

public class DataSourcePool {
	
	@ConfigurationProperties(prefix = "spring.master")
	static class DataSourceProperties extends BaseDataSourceProperties {}
	
	
	/**
	 * 创建数据源
	 * 
	 * @param dataSourceProperties
	 * @return
	 * @throws SQLException
	 */
	static DataSource create(BaseDataSourceProperties dataSourceProperties) throws SQLException {
		DecryptDruidDataSource dataSource = new DecryptDruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());

		// 初始化大小，最小，最大
		dataSource.setInitialSize(dataSourceProperties.getInitialSize());
		dataSource.setMinIdle(dataSourceProperties.getMinIdle());
		dataSource.setMaxActive(dataSourceProperties.getMaxActive());
		// 配置获取连接等待超时的时间
		dataSource.setMaxWait(30000);
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(30000);
		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(300000);
		dataSource.setValidationQuery("select 1");
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		// 打开PSCache，并且指定每个连接上PSCache的大小
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		// 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
		dataSource.addFilters("stat,slf4j");
		// 通过connectProperties属性来打开mergeSql功能；慢SQL记录
		dataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");

		return dataSource;
	}
	
}