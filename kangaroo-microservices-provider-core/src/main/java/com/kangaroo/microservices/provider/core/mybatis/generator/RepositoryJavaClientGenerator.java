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
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.SimpleXMLMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;

public class RepositoryJavaClientGenerator extends AbstractJavaClientGenerator {

	/**
	 * 实体对应RepositoryType接口类型
	 */
	private String myBatis3JavaRepositoryType;

	/**
	 * 父接口列表
	 */
	private Set<String> repositorys = new HashSet<String>();

	public RepositoryJavaClientGenerator(String myBatis3JavaRepositoryType, Set<String> repositorys) {
		super(true);
		this.myBatis3JavaRepositoryType = myBatis3JavaRepositoryType;
		if (repositorys != null) {
			this.repositorys.addAll(repositorys);
		}
	}

	public RepositoryJavaClientGenerator(String myBatis3JavaRepositoryType, Set<String> repositorys,
			boolean requiresMatchedXMLGenerator) {
		super(requiresMatchedXMLGenerator);
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

		FullyQualifiedJavaType type = new FullyQualifiedJavaType(getMyBatis3JavaRepositoryType());
		Interface interfaze = new Interface(type);
		interfaze.setVisibility(JavaVisibility.PUBLIC);
		commentGenerator.addJavaFileComment(interfaze);

		String rootInterface = introspectedTable.getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
		if (!stringHasValue(rootInterface)) {
			rootInterface = context.getJavaClientGeneratorConfiguration()
					.getProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
		}

		if (stringHasValue(rootInterface)) {
			FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
			interfaze.addSuperInterface(fqjt);
			interfaze.addImportedType(fqjt);
		}

		List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
		if (clientGenerated(interfaze, null, introspectedTable)) {
			answer.add(interfaze);
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

	/**
	 * 生成Repository接口
	 * 
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {

		// 获取实体类
		FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		// import接口
		for (String repository : repositorys) {
			interfaze.addImportedType(new FullyQualifiedJavaType(repository));
			interfaze.addSuperInterface(new FullyQualifiedJavaType(repository + "<" + entityType.getShortName() + ">"));
		}
		// import实体类
		interfaze.addImportedType(entityType);

		return true;
	}
}
