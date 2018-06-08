package com.kangaroo.utils.redis;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import com.kangaroo.core.cache.ICacheKey;

public class IntegerRedisHelper extends BaseRedisHelper {

	public IntegerRedisHelper(RedisTemplate<String, String> redisTemplate, int defaultTime, TimeUnit timeUtil) {
		super(redisTemplate, defaultTime, timeUtil);
	}

	public Integer get(String key) {
		String value = getRedisTemplate().opsForValue().get(key);
		if (StringUtils.isNoneEmpty(value)) {
			return Integer.parseInt(value);
		} else {
			return null;
		}
	}

	public Integer get(String key, ICacheKey cacheKey) {
		return this.get(cacheKey.getKey() + key);
	}

	public void set(String key, Integer value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForValue().set(key, value + "", time, timeUnit);
		}
	}

	public void set(String key, Integer value) {
		this.set(key, value, getDefaultTime(), getTimeUtil());
	}

	public void set(String key, Integer value, ICacheKey genkey) {
		this.set(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public Integer getHash(String key, String field) {
		String value = (String) getRedisTemplate().opsForHash().get(key, field);
		if (StringUtils.isNoneEmpty(value)) {
			return Integer.parseInt(value);
		} else {
			return null;
		}
	}

	public Integer getHash(String key, String field, ICacheKey genkey) {
		return this.getHash(genkey.getKey() + key, field);
	}

	public void setHash(String key, String field, Integer value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForHash().put(key, field, value + "");
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void setHash(String key, String field, int value) {
		this.setHash(key, field, value, getDefaultTime(), getTimeUtil());
	}

	public void setHash(String key, String field, int value, ICacheKey genkey) {
		this.setHash(genkey.getKey() + key, field, value, genkey.getTimeout(), genkey.getUnit());
	}
	

	public Integer increment(String key, Integer delta) {
		return getRedisTemplate().opsForValue().increment(key, delta).intValue();
	}

	public Integer increment(String key, Integer delta, ICacheKey genkey) {
		return getRedisTemplate().opsForValue().increment(genkey.getKey() + key, delta).intValue();
	}
}
