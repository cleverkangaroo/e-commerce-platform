package com.kangaroo.microservices.provider.base.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.kangaroo.utils.redis.RedisHelper;

@Configuration
public class RedisTemplateConfig {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	public RedisHelper redisHelper() {
		RedisHelper redisHelper = new RedisHelper();
		redisHelper.setDefaultTime(6);
		redisHelper.setTimeUtil(TimeUnit.HOURS);
		redisHelper.setRedisTemplate(redisTemplate());
		return redisHelper;
	}
}
