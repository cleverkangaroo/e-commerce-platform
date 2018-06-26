package com.kangaroo.microservices.provider.core.mybatis.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 通用Repository生成器插件
 * @author liuwei
 *
 */
public class RepositoryPlugin extends PluginAdapter{

	private Set<String> repositorys = new HashSet<String>();
	
    
	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void setContext(Context context) {
		// TODO Auto-generated method stub
		super.setContext(context);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
		 String repositorys = this.properties.getProperty("repositorys");
	        if (StringUtility.stringHasValue(repositorys)) {
	            for (String repository : repositorys.split(",")) {
	                this.repositorys.add(repository);
	            }
	        } else {
	            throw new RepositoryException("Repository插件缺少必要的repositorys属性!");
	        }
	}

	 /**
     * 生成的Repository接口
     *
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        
    	//获取实体类
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        //import接口
        for (String repository : repositorys) {
            interfaze.addImportedType(new FullyQualifiedJavaType(repository));
            interfaze.addSuperInterface(new FullyQualifiedJavaType(repository + "<" + entityType.getShortName() + ">"));
        }
        //import实体类
        interfaze.addImportedType(entityType);
        return true;
    }
	@Override
	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
		 List<GeneratedJavaFile> list = super.contextGenerateAdditionalJavaFiles(introspectedTable);
		 return list;
	}
	
    
}
