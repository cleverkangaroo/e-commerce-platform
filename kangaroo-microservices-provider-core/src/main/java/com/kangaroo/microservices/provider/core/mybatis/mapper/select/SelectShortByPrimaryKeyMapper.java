package com.kangaroo.microservices.provider.core.mybatis.mapper.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.kangaroo.microservices.provider.core.mybatis.mapper.provider.BaseSelectShortProvider;

public interface SelectShortByPrimaryKeyMapper<T> {

	 /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * 返回定制常用属性
     *
     * @param key
     * @return
     */
    @SelectProvider(type = BaseSelectShortProvider.class, method = "dynamicSQL")
    T selectShortByPrimaryKey(Object key);
}
