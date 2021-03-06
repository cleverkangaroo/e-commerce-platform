package com.kangaroo.microservices.provider.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.kangaroo.microservices.provider.core.mybatis.generator.CustomConfigurationParser;

public class GeneratorDefaultCode {
	public static void generator() {

		List<String> warnings = new ArrayList<String>();
		try {
			Properties extraProperties=new Properties();
			// 解析
			CustomConfigurationParser cp = new CustomConfigurationParser(extraProperties,warnings);
			Configuration config = cp.parseConfiguration(GeneratorDefaultCode.class.getResourceAsStream("/mybatis-generator-default.xml"));
			// 是否覆盖
			DefaultShellCallback dsc = new DefaultShellCallback(true);
			MyBatisGenerator mg = new MyBatisGenerator(config, dsc, warnings);
		   
			mg.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeneratorDefaultCode.generator();
		System.out.println("success!");
	}

}
