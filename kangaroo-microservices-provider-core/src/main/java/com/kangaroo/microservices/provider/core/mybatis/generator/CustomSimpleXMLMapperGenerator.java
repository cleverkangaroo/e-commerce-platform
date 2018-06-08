package com.kangaroo.microservices.provider.core.mybatis.generator;

import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.SimpleXMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BaseColumnListElementGenerator;

public class CustomSimpleXMLMapperGenerator extends SimpleXMLMapperGenerator{

	public CustomSimpleXMLMapperGenerator() {
		super();
		
	}

	
	protected void addBaseColumnListElement(XmlElement parentElement) {
            AbstractXmlElementGenerator elementGenerator = new BaseColumnListElementGenerator();
            initializeAndExecuteGenerator(elementGenerator, parentElement);
	}


	@Override
	protected XmlElement getSqlMapElement() {
		 XmlElement answer = super.getSqlMapElement();
		 addBaseColumnListElement(answer);
		 return answer;
	}

   

}
