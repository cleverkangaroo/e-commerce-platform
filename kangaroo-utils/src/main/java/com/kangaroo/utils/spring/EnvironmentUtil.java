package com.kangaroo.utils.spring;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvUtil implements EnvironmentAware {

	public static Environment env;

	public static String getProperty(String key) {
		return env.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return env.getProperty(key, defaultValue);
	}

	public static <T> T getProperty(String key, Class<T> targetType) {
		return env.getProperty(key, targetType);
	}

	public static <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
		return env.getProperty(key, targetType, defaultValue);
	}

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}
}
