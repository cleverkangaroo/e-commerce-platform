package com.kangaroo.core.cache;

import java.util.concurrent.TimeUnit;

public interface ICacheKey {
	public final static String SEPARATE = ".";

	public String getKey();

	public int getTimeout();

	public TimeUnit getUnit();
}
