package com.kangaroo.api.management.cache;

import java.util.concurrent.TimeUnit;

import com.kangaroo.core.cache.ICacheKey;

public enum SessionKey implements ICacheKey {
	TOKEN("jsessionid", 1, TimeUnit.DAYS);

	private String key;
	private int timeout;
	private TimeUnit unit;

	SessionKey(String key, int timeout, TimeUnit unit) {
		this.key = key;
		this.timeout = timeout;
		this.unit = unit;
	}

	@Override
	public String getKey() {
		return "management" + SEPARATE + key + SEPARATE;
	}

	@Override
	public int getTimeout() {
		return timeout;
	}

	@Override
	public TimeUnit getUnit() {
		return unit;
	}
}
