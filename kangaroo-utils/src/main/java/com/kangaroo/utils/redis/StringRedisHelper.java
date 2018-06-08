package com.kangaroo.utils.redis;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import com.kangaroo.core.cache.ICacheKey;

public class StringRedisHelper extends BaseRedisHelper {
	public StringRedisHelper(RedisTemplate<String, String> redisTemplate, int defaultTime, TimeUnit timeUtil) {
		super(redisTemplate, defaultTime, timeUtil);
	}

	public String get(String key) {
		return getRedisTemplate().opsForValue().get(key);
	}

	public String get(String key, ICacheKey cacheKey) {
		return this.get(cacheKey.getKey() + key);
	}

	public void set(String key, String value, int time, TimeUnit timeUnit) {
		if (StringUtils.isNoneBlank(value)) {
			getRedisTemplate().opsForValue().set(key, value, time, timeUnit);
		}
	}

	public void set(String key, String value) {
		this.set(key, value, getDefaultTime(), getTimeUtil());
	}

	public void set(String key, String value, ICacheKey genkey) {
		this.set(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public String getHash(String key, String field) {
		return (String) getRedisTemplate().opsForHash().get(key, field);
	}

	public String getHash(String key, String field, ICacheKey genkey) {
		return this.getHash(genkey.getKey() + key, field);
	}

	public void setHash(String key, String field, String value, int time, TimeUnit timeUnit) {
		if (StringUtils.isNoneBlank(value)) {
			getRedisTemplate().opsForHash().put(key, field, value);
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void setHash(String key, String field, String value) {
		this.setHash(key, field, value, getDefaultTime(), getTimeUtil());
	}

	public void setHash(String key, String field, String value, ICacheKey genkey) {
		this.setHash(genkey.getKey() + key, field, value, genkey.getTimeout(), genkey.getUnit());
	}

	public Boolean sisMember(String key, String value) {
		if (StringUtils.isNoneBlank(value)) {
			return getRedisTemplate().opsForSet().isMember(key, value);
		}
		return false;
	}

	public Boolean sisMember(String key, String value, ICacheKey genkey) {
		return this.sisMember(genkey.getKey() + key, value);
	}

	public void sadd(String key, String value, int time, TimeUnit timeUnit) {
		if (StringUtils.isNoneBlank(value)) {
			getRedisTemplate().opsForSet().add(key, value);
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void sadd(String key, String value) {
		this.sadd(key, value, getDefaultTime(), getTimeUtil());
	}

	public void sadd(String key, String value, ICacheKey genkey) {
		this.sadd(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public void sremove(String key, String value, ICacheKey genkey) {
		this.sremove(genkey.getKey() + key, value);
	}

	public void sremove(String key, String value) {
		if (StringUtils.isNoneBlank(value)) {
			getRedisTemplate().opsForSet().remove(key, value);
		}
	}

	public boolean setIfAbsent(String key, String value, ICacheKey genkey) {
		return this.setIfAbsent(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public boolean setIfAbsent(String key, String value) {
		return this.setIfAbsent(key, value, getDefaultTime(), getTimeUtil());
	}

	public boolean setIfAbsent(String key, String value, int time, TimeUnit timeUnit) {
		if (StringUtils.isNoneBlank(value)) {
			boolean result = getRedisTemplate().opsForValue().setIfAbsent(key, value);
			if (result) {
				getRedisTemplate().expire(key, time, timeUnit);
			}
			return result;
		}
		return false;
	}

}
