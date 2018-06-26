package com.kangaroo.microservices.provider.core.mybatis.generator;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.config.xml.ConfigurationParser;

public class CustomConfigurationParser extends ConfigurationParser{

	public CustomConfigurationParser(List<String> warnings) {
		super(warnings);
	}

	public CustomConfigurationParser(Properties extraProperties, List<String> warnings) {
		super(extraProperties, warnings);
	}
	
}
