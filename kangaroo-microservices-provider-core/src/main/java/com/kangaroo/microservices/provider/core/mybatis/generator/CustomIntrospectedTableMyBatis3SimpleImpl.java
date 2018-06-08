package com.kangaroo.microservices.provider.core.mybatis.generator;

import java.util.List;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl;
import org.mybatis.generator.codegen.mybatis3.javamapper.SimpleAnnotatedClientGenerator;
import org.mybatis.generator.codegen.mybatis3.model.SimpleModelGenerator;
import org.mybatis.generator.internal.ObjectFactory;

public class CustomIntrospectedTableMyBatis3SimpleImpl extends IntrospectedTableMyBatis3SimpleImpl{

	public CustomIntrospectedTableMyBatis3SimpleImpl() {
		super();
	}

	 
	 @Override
	    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, 
	            List<String> warnings,
	            ProgressCallback progressCallback) {
	        if (javaClientGenerator == null) {
	            if (context.getSqlMapGeneratorConfiguration() != null) {
	                xmlMapperGenerator = new CustomSimpleXMLMapperGenerator();
	            }
	        } else {
	            xmlMapperGenerator = javaClientGenerator.getMatchedXMLGenerator();
	        }
	        
	        initializeAbstractGenerator(xmlMapperGenerator, warnings,
	                progressCallback);
	    }

	    @Override
	    protected AbstractJavaClientGenerator createJavaClientGenerator() {
	        if (context.getJavaClientGeneratorConfiguration() == null) {
	            return null;
	        }
	        
	        String type = context.getJavaClientGeneratorConfiguration()
	                .getConfigurationType();

	        AbstractJavaClientGenerator javaGenerator;
	        if ("XMLMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
	            javaGenerator = new CustomSimpleJavaClientGenerator();
	        } else if ("ANNOTATEDMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
	            javaGenerator = new SimpleAnnotatedClientGenerator();
	        } else if ("MAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
	            javaGenerator = new CustomSimpleJavaClientGenerator();
	        } else {
	            javaGenerator = (AbstractJavaClientGenerator) ObjectFactory
	                    .createInternalObject(type);
	        }
	        
	        return javaGenerator;
	    }

	    @Override
	    protected void calculateJavaModelGenerators(List<String> warnings,
	            ProgressCallback progressCallback) {

	        AbstractJavaGenerator javaGenerator = new SimpleModelGenerator();
	        initializeAbstractGenerator(javaGenerator, warnings,
	                progressCallback);
	        javaModelGenerators.add(javaGenerator);
	    }
}
