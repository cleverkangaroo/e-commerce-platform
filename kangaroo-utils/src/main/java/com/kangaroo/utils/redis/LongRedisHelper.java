package com.kangaroo.utils.redis;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import com.kangaroo.core.cache.ICacheKey;

public class LongRedisHelper extends BaseRedisHelper {

	public LongRedisHelper(RedisTemplate<String, String> redisTemplate, int defaultTime, TimeUnit timeUtil) {
		super(redisTemplate, defaultTime, timeUtil);
	}

	public Long get(String key) {
		String value = getRedisTemplate().opsForValue().get(key);
		if (StringUtils.isNoneEmpty(value)) {
			return Long.parseLong(value);
		} else {
			return null;
		}
	}

	public Long get(String key, ICacheKey cacheKey) {
		return this.get(cacheKey.getKey() + key);
	}

	public void set(String key, Long value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForValue().set(key, value + "", time, timeUnit);
		}
	}

	public void set(String key, Long value) {
		this.set(key, value, getDefaultTime(), getTimeUtil());
	}

	public void set(String key, Long value, ICacheKey genkey) {
		this.set(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public Long getHash(String key, String field) {
		String value = (String) getRedisTemplate().opsForHash().get(key, field);
		if (StringUtils.isNoneEmpty(value)) {
			return Long.parseLong(value);
		} else {
			return null;
		}
	}

	public long getHash(String key, String field, ICacheKey genkey) {
		return this.getHash(genkey.getKey() + key, field);
	}
	
	public Long increment(String key, Long delta) {
		return getRedisTemplate().opsForValue().increment(key, delta);
	}

	public Long increment(String key, Long delta, ICacheKey genkey) {
		return getRedisTemplate().opsForValue().increment(genkey.getKey() + key, delta);
	}

}
