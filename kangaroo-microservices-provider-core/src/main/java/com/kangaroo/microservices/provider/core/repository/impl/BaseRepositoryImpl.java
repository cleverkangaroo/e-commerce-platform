package com.kangaroo.microservices.provider.core.repository.impl;

import java.util.List;

import com.kangaroo.microservices.provider.core.repository.BaseRepository;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	protected abstract Mapper<T> getBaseMapper();

	public T selectByPrimaryKey(Object key) {
		return getBaseMapper().selectByPrimaryKey(key);
	}

	public int updateByPrimaryKeySelective(T record) {
		return getBaseMapper().updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return getBaseMapper().updateByPrimaryKey(record);
	}

	public int deleteByPrimaryKey(Object key) {
		return getBaseMapper().deleteByPrimaryKey(key);
	}


	public int insertSelective(T record) {
		return getBaseMapper().insertSelective(record);
	}

	public int insert(T record) {
		return getBaseMapper().insert(record);
	}

	public T selectOne(T record) {
		return getBaseMapper().selectOne(record);
	}

	public int selectCount(T record) {
		return getBaseMapper().selectCount(record);
	}


	public List<T> select(T record) {
		return getBaseMapper().select(record);
	}

	@Override
	public int delete(T record) {
		return getBaseMapper().delete(record);
	}




}
