package com.kangaroo.microservices.provider.base.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ DataSourcePool.MasterDataSource.class })
public class DruidConfiguration {

	@Bean(name = "masterDataSource", initMethod = "init", destroyMethod = "close")
	public DataSource mainDataSource(@Autowired DataSourcePool.MasterDataSource mainDataSource) throws SQLException {
		return DataSourcePool.create(mainDataSource);
	}
}
