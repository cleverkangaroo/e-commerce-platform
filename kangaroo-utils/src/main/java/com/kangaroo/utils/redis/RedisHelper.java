package com.kangaroo.utils.redis;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;

import com.kangaroo.core.cache.ICacheKey;


public class RedisHelper extends AbstractRedisHelper implements InitializingBean {
	private StringRedisHelper opsForString;
	private LongRedisHelper opsForLong;
	private ObjectRedisHelper opsForObject;
	private IntegerRedisHelper opsForInteger;

	public void afterPropertiesSet() throws Exception {
		if (Objects.isNull(opsForString)) {
			opsForString = new StringRedisHelper(getRedisTemplate(), getDefaultTime(), getTimeUtil());
		}
		if (Objects.isNull(opsForLong)) {
			opsForLong = new LongRedisHelper(getRedisTemplate(), getDefaultTime(), getTimeUtil());
		}
		if (Objects.isNull(opsForObject)) {
			opsForObject = new ObjectRedisHelper(getRedisTemplate(), getDefaultTime(), getTimeUtil());
		}
		if (Objects.isNull(opsForInteger)) {
			opsForInteger = new IntegerRedisHelper(getRedisTemplate(), getDefaultTime(), getTimeUtil());
		}
	}

	public StringRedisHelper opsForString() {
		return opsForString;
	}

	public void setOpsForString(StringRedisHelper opsForString) {
		this.opsForString = opsForString;
	}

	public LongRedisHelper opsForLong() {
		return opsForLong;
	}

	public void setOpsForLong(LongRedisHelper opsForLong) {
		this.opsForLong = opsForLong;
	}

	public ObjectRedisHelper opsForObject() {
		return opsForObject;
	}

	public void setOpsForObject(ObjectRedisHelper opsForObject) {
		this.opsForObject = opsForObject;
	}

	public IntegerRedisHelper opsForInteger() {
		return opsForInteger;
	}

	public void setOpsForInteger(IntegerRedisHelper opsForInteger) {
		this.opsForInteger = opsForInteger;
	}

	public void setHash(String key, String field, long value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForHash().put(key, field, value + "");
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void setHash(String key, String field, long value) {
		this.setHash(key, field, value, getDefaultTime(), getTimeUtil());
	}

	public void setHash(String key, String field, long value, ICacheKey genkey) {
		this.setHash(genkey.getKey() + key, field, value, genkey.getTimeout(), genkey.getUnit());
	}

	public void delHash(String key, String field) {
		getRedisTemplate().opsForHash().delete(key, field);
	}

	public void delHash(String key, String field, ICacheKey genkey) {
		this.delHash(genkey.getKey() + key, field);
	}

	public boolean hasKey(String key) {
		return getRedisTemplate().hasKey(key);
	}

	public boolean hasKey(String key, ICacheKey genkey) {
		return this.hasKey(genkey.getKey() + key);
	}

	public boolean expire(String key, int time, TimeUnit timeUnit) {
		return getRedisTemplate().expire(key, (long) time, timeUnit);
	}

	public boolean expire(String key, ICacheKey genkey) {
		return this.expire(genkey.getKey() + key, genkey.getTimeout(), genkey.getUnit());
	}
	
	public boolean expire(String key, int time, TimeUnit timeUnit, ICacheKey genkey) {
		return this.expire(genkey.getKey() + key, time, timeUnit);
	}

	public long getExpire(String key, TimeUnit timeUnit) {
		return getRedisTemplate().getExpire(key, timeUnit);
	}
	
	public long getExpire(String key, ICacheKey genkey) {
		return this.getExpire(genkey.getKey() + key, genkey.getUnit());
	}

	public long getExpire(String key, TimeUnit timeUnit, ICacheKey genkey) {
		return this.getExpire(genkey.getKey() + key, timeUnit);
	}

	public void del(String key) {
		getRedisTemplate().delete(key);
	}

	public void del(String key, ICacheKey genkey) {
		this.del(genkey.getKey() + key);
	}
}
