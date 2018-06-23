package com.kangaroo.microservices.provider.core.repository;

import java.util.List;

public interface BaseRepository<T> {
	
	public T selectByPrimaryKey(Object key);

	public int updateByPrimaryKeySelective(T record);

	public int updateByPrimaryKey(T record);

	public int deleteByPrimaryKey(Object key);

	public int delete(T record);

	public int insertSelective(T record);

	public int insert(T record);

	public T selectOne(T record);

	public int selectCount(T record);

	public List<T> select(T record);


}
