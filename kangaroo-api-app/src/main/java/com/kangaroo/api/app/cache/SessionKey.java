package com.kangaroo.api.app.cache;

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
