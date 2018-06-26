package com.kangaroo.microservices.provider.core.mybatis.generator;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.SimpleXMLMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kangaroo.utils.CommonStringUtils;

import tk.mybatis.mapper.common.Mapper;

public class RepositoryImplJavaClientGenerator extends AbstractJavaClientGenerator {

	/**
	 * 实体对应RepositoryImplType实现类类型
	 */
	private String myBatis3JavaRepositoryImplType;

	/**
	 * 实体对应RepositoryType接口类型
	 */
	private String myBatis3JavaRepositoryType;
	/**
	 * 父类列表
	 */
	private Set<String> repositorys = new HashSet<String>();

	public RepositoryImplJavaClientGenerator(String myBatis3JavaRepositoryImplType, String myBatis3JavaRepositoryType,
			Set<String> repositorys) {
		super(true);
		this.myBatis3JavaRepositoryImplType = myBatis3JavaRepositoryImplType;
		this.myBatis3JavaRepositoryType = myBatis3JavaRepositoryType;
		if (repositorys != null) {
			this.repositorys.addAll(repositorys);
		}
	}

	public RepositoryImplJavaClientGenerator(String myBatis3JavaRepositoryImplType, String myBatis3JavaRepositoryType,
			Set<String> repositorys, boolean requiresMatchedXMLGenerator) {
		super(requiresMatchedXMLGenerator);
		this.myBatis3JavaRepositoryImplType = myBatis3JavaRepositoryImplType;
		this.myBatis3JavaRepositoryType = myBatis3JavaRepositoryType;
		if (repositorys != null) {
			this.repositorys.addAll(repositorys);
		}
	}

	@Override
	public List<CompilationUnit> getCompilationUnits() {
		progressCallback.startTask(getString("Progress.17", //$NON-NLS-1$
				introspectedTable.getFullyQualifiedTable().toString()));
		CommentGenerator commentGenerator = context.getCommentGenerator();

		FullyQualifiedJavaType type = new FullyQualifiedJavaType(getMyBatis3JavaRepositoryImplType());
		TopLevelClass topLevelClass = new TopLevelClass(type);
		topLevelClass.setVisibility(JavaVisibility.PUBLIC);
		commentGenerator.addJavaFileComment(topLevelClass);

		String rootClass = introspectedTable.getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_CLASS);
		if (!stringHasValue(rootClass)) {
			rootClass = context.getJavaClientGeneratorConfiguration().getProperty(PropertyRegistry.ANY_ROOT_CLASS);
		}

		if (stringHasValue(rootClass)) {
			FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootClass);
			topLevelClass.setSuperClass(fqjt);
			topLevelClass.addImportedType(fqjt);
		}

		List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
		if (clientGenerated(null, topLevelClass, introspectedTable)) {
			answer.add(topLevelClass);
		}
		List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
		if (extraCompilationUnits != null) {
			answer.addAll(extraCompilationUnits);
		}

		return answer;
	}

	protected void initializeAndExecuteGenerator(AbstractJavaMapperMethodGenerator methodGenerator,
			Interface interfaze) {
		methodGenerator.setContext(context);
		methodGenerator.setIntrospectedTable(introspectedTable);
		methodGenerator.setProgressCallback(progressCallback);
		methodGenerator.setWarnings(warnings);
		methodGenerator.addInterfaceElements(interfaze);
	}

	public List<CompilationUnit> getExtraCompilationUnits() {
		return null;
	}

	@Override
	public AbstractXmlGenerator getMatchedXMLGenerator() {
		return new SimpleXMLMapperGenerator();
	}

	public String getMyBatis3JavaRepositoryType() {
		return this.myBatis3JavaRepositoryType;
	}

	private String getMyBatis3JavaRepositoryImplType() {
		return myBatis3JavaRepositoryImplType;
	}

	/**
	 * 生成RepositoryImpl类
	 * 
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {

		addSuperClass(topLevelClass, introspectedTable);
		addSuperInterface(topLevelClass);
		addClassAnnotation(topLevelClass);
		String mapperTypeName = addMapperField(topLevelClass, introspectedTable);
		addGetBaseMapperMethod(topLevelClass, introspectedTable, mapperTypeName);

		return true;
	}

	private void addGetBaseMapperMethod(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,
			String mapperTypeName) {
		// 获取实体类
		FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		Method method = new Method();
		method.setName("getBaseMapper");
		method.setReturnType(
				new FullyQualifiedJavaType(Mapper.class.getTypeName() + "<" + entityType.getShortName() + ">"));
		method.setVisibility(JavaVisibility.PUBLIC);
		StringBuilder sb = new StringBuilder();
		sb.append("return "); //$NON-NLS-1$
		sb.append(mapperTypeName);
		sb.append(';');
		method.addBodyLine(sb.toString());
		method.addAnnotation("@" + Override.class.getSimpleName());
		topLevelClass.addImportedType(new FullyQualifiedJavaType(Mapper.class.getTypeName()));
		topLevelClass.addImportedType(Override.class.getTypeName());
		topLevelClass.addMethod(method);
	}

	/**
	 * 添加自动注入的mapper属性
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	private String addMapperField(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		Field field = new Field();
		field.setVisibility(JavaVisibility.PRIVATE);
		FullyQualifiedJavaType mapperType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()); // $NON-NLS-1$
		field.setType(mapperType);
		String mapperTypeName = CommonStringUtils.toLowerCaseFirst(mapperType.getShortNameWithoutTypeArguments());
		field.setName(mapperTypeName); // $NON-NLS-1$
		field.addAnnotation("@" + Autowired.class.getSimpleName());

		topLevelClass.addField(field);
		topLevelClass.addImportedType(Autowired.class.getTypeName());
		topLevelClass.addImportedType(mapperType);
		return mapperTypeName;
	}

	/**
	 * 添加类注解
	 * 
	 * @param topLevelClass
	 */
	private void addClassAnnotation(TopLevelClass topLevelClass) {
		topLevelClass.addAnnotation("@" + Repository.class.getSimpleName());
		topLevelClass.addImportedType(Repository.class.getTypeName());
	}

	/**
	 * 添加父类信息
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	private TopLevelClass addSuperClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 获取实体类
		FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		// import父类
		for (String repository : repositorys) {
			topLevelClass.addImportedType(new FullyQualifiedJavaType(repository));
			topLevelClass.setSuperClass(new FullyQualifiedJavaType(repository + "<" + entityType.getShortName() + ">"));
		}
		// import实体类
		topLevelClass.addImportedType(entityType);
		return topLevelClass;
	}

	/**
	 * 添加父接口信息
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	private TopLevelClass addSuperInterface(TopLevelClass topLevelClass) {
		// import父接口
		topLevelClass.addImportedType(new FullyQualifiedJavaType(getMyBatis3JavaRepositoryType()));
		topLevelClass.addSuperInterface(new FullyQualifiedJavaType(getMyBatis3JavaRepositoryType()));
		return topLevelClass;
	}
}
