package com.kangaroo.microservices.provider.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.kangaroo.microservices.provider.core.mybatis.config.MyBatisMapperScannerConfig;

@EnableDiscoveryClient
@SpringBootApplication
@Import({ MyBatisMapperScannerConfig.class })
public class MicroBaseApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(MicroBaseApplication.class).web(true).run(args);
	}
}
