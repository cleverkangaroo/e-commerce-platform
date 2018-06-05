package com.kangaroo.microservices.provider.core.mybatis.mapper;

import com.kangaroo.microservices.provider.core.mybatis.mapper.select.SelectShortByPrimaryKeyMapper;

import tk.mybatis.mapper.common.Marker;

/**
 * 定制扩展接口，其他接口继承该接口即可
 * 应用场景，根据需求返回表中部分常用字段
 */
public interface CustomMapper<T> extends SelectShortByPrimaryKeyMapper<T> ,Marker{

}
