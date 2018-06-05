package com.kangaroo.microservices.provider.core.mybatis.mapper.provider;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class BaseSelectShortProvider extends MapperTemplate{

	 public BaseSelectShortProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
	        super(mapperClass, mapperHelper);
	    }
	 
	 /**
	     * 根据主键进行查询，返回表中对应常用属性
	     *
	     * @param ms
	     */
	    public String selectShortByPrimaryKey(MappedStatement ms) {
	        final Class<?> entityClass = getEntityClass(ms);
	        //将返回值修改为实体类型
	        setResultType(ms, entityClass);
	        StringBuilder sql = new StringBuilder();
	        sql.append(SqlHelper.selectAllColumns(entityClass));
	        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
	        sql.append(SqlHelper.wherePKColumns(entityClass));
	        return sql.toString();
	    }
}
