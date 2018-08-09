package com.kangaroo.microservices.provider.base.dao;

import org.apache.ibatis.annotations.Param;

import com.kangaroo.microservices.provider.base.model.entity.Users;
import tk.mybatis.mapper.common.Mapper;

public interface UsersMapper extends Mapper<Users> {
	
	/**
	 * 根据登陆名及登陆类型，查找用户
	 * @param username
	 * @param dtype
	 * @return
	 */
	public Users selectByUsernameAndDtype(@Param(value="username") String username,@Param(value="dtype")String dtype);
}