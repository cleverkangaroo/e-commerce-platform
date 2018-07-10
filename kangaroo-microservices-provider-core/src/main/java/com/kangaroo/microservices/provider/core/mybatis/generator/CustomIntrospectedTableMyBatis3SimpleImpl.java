package com.kangaroo.microservices.provider.core.mybatis.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3SimpleImpl;
import org.mybatis.generator.codegen.mybatis3.javamapper.SimpleAnnotatedClientGenerator;
import org.mybatis.generator.codegen.mybatis3.model.SimpleModelGenerator;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.PropertyHolder;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.generator.internal.util.StringUtility;

public class CustomIntrospectedTableMyBatis3SimpleImpl extends IntrospectedTableMyBatis3SimpleImpl{
	
	/**
	 * 通用repository接口类型
	 */
	private String repositoryInterfaceType;
	
	/**
	 * 通用repository实现类类型
	 */
	private String repositoryImplementationType;
	

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
		public void calculateGenerators(List<String> warnings, ProgressCallback progressCallback) {
			// TODO Auto-generated method stub
			super.calculateGenerators(warnings, progressCallback);
			calculateRepositoryGenerators(warnings, progressCallback);
			calculateRepositoryImplGenerators(warnings, progressCallback);
			
		}

		 protected AbstractJavaClientGenerator calculateRepositoryGenerators(List<String> warnings,
		            ProgressCallback progressCallback) {
		        if (!rules.generateJavaClient()) {
		            return null;
		        }
		        
		        AbstractJavaClientGenerator javaGenerator = new RepositoryJavaClientGenerator(repositoryInterfaceType,calculateJavaRepositoryInterface());
		        initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
		        clientGenerators.add(javaGenerator);
		        
		        return javaGenerator;
		    }
		 
		 protected AbstractJavaClientGenerator calculateRepositoryImplGenerators(List<String> warnings,
		            ProgressCallback progressCallback) {
		        if (!rules.generateJavaClient()) {
		            return null;
		        }
		        
		        AbstractJavaClientGenerator javaGenerator = new RepositoryImplJavaClientGenerator(repositoryImplementationType,repositoryInterfaceType,calculateJavaRepositoryImplementation());
		        initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
		        clientGenerators.add(javaGenerator);
		        
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
	    
	    


		@Override
		protected String calculateJavaClientImplementationPackage() {
			// TODO Auto-generated method stub
			return super.calculateJavaClientImplementationPackage();
		}


		
		protected String calculateJavaRepositoryImplementationPackage() {
		JavaClientGeneratorConfiguration config = context.getJavaClientGeneratorConfiguration();
		if (config == null) {
			return null;
		}
		String repositoryImplementationPackage = context.getProperty("repository.implementation.package");

		if (repositoryImplementationPackage == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(repositoryImplementationPackage);

		sb.append(fullyQualifiedTable.getSubPackageForClientOrSqlMap(isSubPackagesEnabled(config)));

		return sb.toString();
		}
		
		@Override
		protected String calculateJavaClientInterfacePackage() {
			// TODO Auto-generated method stub
			return super.calculateJavaClientInterfacePackage();
		}

		protected String calculateJavaRepositoryInterfacePackage() {
			
		JavaClientGeneratorConfiguration config = context.getJavaClientGeneratorConfiguration();
		if (config == null) {
			return null;
		}
		String repositoryInterfacePackage = context.getProperty("repository.interface.package");

		if (repositoryInterfacePackage == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(repositoryInterfacePackage);

		sb.append(fullyQualifiedTable.getSubPackageForClientOrSqlMap(isSubPackagesEnabled(config)));

		return sb.toString();
		} 
		

		@Override
		protected void calculateJavaClientAttributes() {
			 if (context.getJavaClientGeneratorConfiguration() == null) {
		            return;
		        }
				
		        StringBuilder sb = new StringBuilder();
		        sb.append(calculateJavaClientImplementationPackage());
		        sb.append('.');
		        sb.append(fullyQualifiedTable.getDomainObjectName());
		        sb.append("DAOImpl"); //$NON-NLS-1$
		        setDAOImplementationType(sb.toString());

		        sb.setLength(0);
		        sb.append(calculateJavaClientInterfacePackage());
		        sb.append('.');
		        sb.append(fullyQualifiedTable.getDomainObjectName());
		        sb.append("DAO"); //$NON-NLS-1$
		        setDAOInterfaceType(sb.toString());

		        sb.setLength(0);
		        sb.append(calculateJavaClientInterfacePackage());
		        sb.append('.');
		        if (stringHasValue(tableConfiguration.getMapperName())) {
		            sb.append(tableConfiguration.getMapperName());
		        } else {
		            sb.append(fullyQualifiedTable.getDomainObjectName());
		            sb.append("Mapper"); //$NON-NLS-1$
		        }
		        setMyBatis3JavaMapperType(sb.toString());

		        sb.setLength(0);
		        sb.append(calculateJavaClientInterfacePackage());
		        sb.append('.');
		        if (stringHasValue(tableConfiguration.getSqlProviderName())) {
		            sb.append(tableConfiguration.getSqlProviderName());
		        } else {
		            sb.append(fullyQualifiedTable.getDomainObjectName());
		            sb.append("SqlProvider"); //$NON-NLS-1$
		        }
		        setMyBatis3SqlProviderType(sb.toString());
		        
		        if (calculateJavaRepositoryInterfacePackage()!=null) {
		        	sb.setLength(0);
			        sb.append(calculateJavaRepositoryInterfacePackage());
			        sb.append('.');
			        sb.append(fullyQualifiedTable.getDomainObjectName());
			        sb.append("Repository"); //$NON-NLS-1$
			        setRepositoryInterfaceType(sb.toString());
				}
		       
		        if (calculateJavaRepositoryImplementationPackage()!=null) {
		        	 
		        	sb.setLength(0);
		        	sb.append(calculateJavaRepositoryImplementationPackage());
			        sb.append('.');
			        sb.append(fullyQualifiedTable.getDomainObjectName());
			        sb.append("RepositoryImpl"); //$NON-NLS-1$
			        setRepositoryImplementationType(sb.toString());
				}
		      
		       
		}


		@Override
		public List<GeneratedJavaFile> getGeneratedJavaFiles() {
			// TODO Auto-generated method stub
			return super.getGeneratedJavaFiles();
		}
		
		
	 private boolean isSubPackagesEnabled(PropertyHolder propertyHolder) {
	        return isTrue(propertyHolder.getProperty(PropertyRegistry.ANY_ENABLE_SUB_PACKAGES));
	    }


	public String getRepositoryInterfaceType() {
		return repositoryInterfaceType;
	}


	private void setRepositoryInterfaceType(String repositoryInterfaceType) {
		this.repositoryInterfaceType = repositoryInterfaceType;
	}


	public String getRepositoryImplementationType() {
		return repositoryImplementationType;
	}


	private void setRepositoryImplementationType(String repositoryImplementationType) {
		this.repositoryImplementationType = repositoryImplementationType;
	}
	 
	 
   protected Set<String> calculateJavaRepositoryInterface(){
	   Set<String> repositorys = new HashSet<String>();
	   String repositoryInterfaces = context.getProperty("repository.interfaces");
       if (StringUtility.stringHasValue(repositoryInterfaces)) {
           for (String repositoryInterface : repositoryInterfaces.split(",")) {
               repositorys.add(repositoryInterface);
           }
       } 
       return repositorys;
   }
   
   protected Set<String> calculateJavaRepositoryImplementation(){
	   Set<String> repositorys = new HashSet<String>();
	   String repositoryImplementations = context.getProperty("repository.implementations");
       if (StringUtility.stringHasValue(repositoryImplementations)) {
           for (String repositoryInterface : repositoryImplementations.split(",")) {
               repositorys.add(repositoryInterface);
           }
       } 
       return repositorys;
       
   }
}
