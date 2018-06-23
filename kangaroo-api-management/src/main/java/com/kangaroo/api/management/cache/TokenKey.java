package com.kangaroo.api.management.cache;

import com.kangaroo.core.cache.ICacheKey;

import java.util.concurrent.TimeUnit;

public enum TokenKey implements ICacheKey {
	TOKEN("token", 2, TimeUnit.HOURS);

	private String key;
	private int timeout;
	private TimeUnit unit;

	TokenKey(String key, int timeout, TimeUnit unit) {
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
