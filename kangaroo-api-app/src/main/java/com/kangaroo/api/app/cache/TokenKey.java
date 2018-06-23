package com.kangaroo.api.app.cache;

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

	public String getKey() {
		return "app" + SEPARATE + key + SEPARATE;
	}

	public int getTimeout() {
		return timeout;
	}

	public TimeUnit getUnit() {
		return unit;
	}
}
