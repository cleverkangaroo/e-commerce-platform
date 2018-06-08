package com.kangaroo.utils.redis;

import com.kangaroo.core.cache.ICacheKey;
import com.kangaroo.utils.json.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ObjectRedisHelper extends BaseRedisHelper {

	public ObjectRedisHelper(RedisTemplate<String, String> redisTemplate, int defaultTime, TimeUnit timeUtil) {
		super(redisTemplate, defaultTime, timeUtil);
	}

	public <N extends Object> N get(String key, Class<N> clazz) {
		String value = getRedisTemplate().opsForValue().get(key);
		if (StringUtils.isNoneEmpty(value)) {
			return JacksonUtil.jsonToObject(value, clazz);
		} else {
			return null;
		}
	}

	public <N extends Object> N get(String key, ICacheKey cacheKey, Class<N> clazz) {
		return this.get(cacheKey.getKey() + key, clazz);
	}

	public Object get(String key, Class<?> collectionClass, Class<?>... elementClasses) {
		String value = getRedisTemplate().opsForValue().get(key);
		if (StringUtils.isNoneEmpty(value)) {
			return JacksonUtil.jsonToObject(value, collectionClass, elementClasses);
		} else {
			return null;
		}
	}

	public Object get(String key, ICacheKey cacheKey, Class<?> collectionClass, Class<?>... elementClasses) {
		return this.get(cacheKey.getKey() + key, collectionClass, elementClasses);
	}
	
	/**
	 * 用泛型返回List,减少强转
	 * @param key
	 * @param clazz
	 * @return value为空时,此处必须是null,而非emptyList()
	 */
	@SuppressWarnings("unchecked")
	public <N> List<N> getList(String key, Class<N> clazz) {
		String value = getRedisTemplate().opsForValue().get(key);
		if (StringUtils.isNoneEmpty(value)) {
			return JacksonUtil.jsonToList(value, clazz);
		} else {
			return null;
		}
	}

	/**
	 * 用泛型返回List,减少强转
	 * @param key
	 * @param cacheKey
	 * @param clazz
	 * @return
	 */
	public <N> List<N> getList(String key, ICacheKey cacheKey, Class<N> clazz) {
		return this.getList(cacheKey.getKey() + key, clazz);
	}

	public void set(String key, Object value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForValue().set(key, JacksonUtil.objectToJson(value), time, timeUnit);
		}
	}

	public void set(String key, Object value) {
		this.set(key, value, getDefaultTime(), getTimeUtil());
	}

	public void set(String key, Object value, ICacheKey genkey) {
		this.set(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public <N extends Object> N getHash(String key, String field, Class<N> clazz) {
		String value = (String) getRedisTemplate().opsForHash().get(key, field);
		if (StringUtils.isNoneEmpty(value)) {
			return JacksonUtil.jsonToObject(value, clazz);
		} else {
			return null;
		}
	}

	public <N extends Object> N getHash(String key, String field, ICacheKey genkey, Class<N> clazz) {
		return this.getHash(genkey.getKey() + key, field, clazz);
	}

	public Object getHash(String key, String field, Class<?> collectionClass, Class<?>... elementClasses) {
		String value = (String) getRedisTemplate().opsForHash().get(key, field);
		if (StringUtils.isNoneEmpty(value)) {
			return JacksonUtil.jsonToObject(value, collectionClass, elementClasses);
		} else {
			return null;
		}
	}

	public Object getHash(String key, String field, ICacheKey genkey, Class<?> collectionClass,
			Class<?>... elementClasses) {
		return this.getHash(genkey.getKey() + key, field, collectionClass, elementClasses);
	}

	public void setHash(String key, String field, Object value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForHash().put(key, field, JacksonUtil.objectToJson(value));
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void setHash(String key, String field, Object value) {
		this.setHash(key, field, value, getDefaultTime(), getTimeUtil());
	}

	public void setHash(String key, String field, Object value, ICacheKey genkey) {
		this.setHash(genkey.getKey() + key, field, value, genkey.getTimeout(), genkey.getUnit());
	}

	public Boolean sisMember(String key, Object value) {
		if (Objects.nonNull(value)) {
			return getRedisTemplate().opsForSet().isMember(key, JacksonUtil.objectToJson(value));
		}
		return false;
	}

	public Boolean sisMember(String key, Object value, ICacheKey genkey) {
		return this.sisMember(genkey.getKey() + key, value);
	}

	public void sadd(String key, Object value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			getRedisTemplate().opsForSet().add(key, JacksonUtil.objectToJson(value));
			getRedisTemplate().expire(key, time, timeUnit);
		}
	}

	public void sadd(String key, Object value) {
		this.sadd(key, value, getDefaultTime(), getTimeUtil());
	}

	public void sadd(String key, Object value, ICacheKey genkey) {
		this.sadd(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public boolean setIfAbsent(String key, Object value, ICacheKey genkey) {
		return this.setIfAbsent(genkey.getKey() + key, value, genkey.getTimeout(), genkey.getUnit());
	}

	public boolean setIfAbsent(String key, Object value) {
		return this.setIfAbsent(key, value, getDefaultTime(), getTimeUtil());
	}

	public boolean setIfAbsent(String key, Object value, int time, TimeUnit timeUnit) {
		if (Objects.nonNull(value)) {
			boolean result = getRedisTemplate().opsForValue().setIfAbsent(key, JacksonUtil.objectToJson(value));
			if (result) {
				getRedisTemplate().expire(key, time, timeUnit);
			}
			return result;
		}
		return false;
	}
}
