package com.kangaroo.microservices.provider.core.mybatis.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.kangaroo.microservices.provider.core.mybatis.transaction.Scan;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@Import(MyBatisConfiguration.class)
@ComponentScan(basePackageClasses = Scan.class)
public class MyBatisMapperScannerConfig {


	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.kangaroo.microservices.provider.*.dao");
		Properties properties = new Properties();
		properties.setProperty("mappers",
				"tk.mybatis.mapper.common.Mapper,tk.mybatis.mapper.common.MySqlMapper,tk.mybatis.mapper.common.IdsMapper,com.kangaroo.microservices.provider.core.mybatis.mapper.CustomMapper");
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "select uuid()");
		properties.setProperty("ORDER", "BEFORE");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

}