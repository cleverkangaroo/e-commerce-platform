package com.kangaroo.microservices.provider.base.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ DataSourcePool.DataSourceProperties.class })
public class DruidConfiguration {

	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	public DataSource dataSource(@Autowired DataSourcePool.DataSourceProperties dataSourceProperties) throws SQLException {
		return DataSourcePool.create(dataSourceProperties);
	}
}
