package com.kangaroo.utils.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

public class AbstractRedisHelper {
	private int defaultTime;
	private TimeUnit timeUtil;
	private RedisTemplate<String, String> redisTemplate;
	
	public TimeUnit getTimeUtil() {
		return timeUtil;
	}

	public void setTimeUtil(TimeUnit timeUtil) {
		this.timeUtil = timeUtil;
	}

	public int getDefaultTime() {
		return defaultTime;
	}

	public void setDefaultTime(int defaultTime) {
		this.defaultTime = defaultTime;
	}

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
