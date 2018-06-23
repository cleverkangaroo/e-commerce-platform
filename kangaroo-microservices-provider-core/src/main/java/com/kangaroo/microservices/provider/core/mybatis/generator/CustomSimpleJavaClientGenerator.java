package com.kangaroo.microservices.provider.core.mybatis.generator;

import java.util.List;

import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.SimpleJavaClientGenerator;

public class CustomSimpleJavaClientGenerator extends SimpleJavaClientGenerator{

	public CustomSimpleJavaClientGenerator() {
		super(true);
	}

	public CustomSimpleJavaClientGenerator(boolean requiresMatchedXMLGenerator) {
		super(requiresMatchedXMLGenerator);
	}

	@Override
	public AbstractXmlGenerator getMatchedXMLGenerator() {
		return new CustomSimpleXMLMapperGenerator();
	}

	@Override
	public List<CompilationUnit> getExtraCompilationUnits() {
		
		return super.getExtraCompilationUnits();
	}

	
}
