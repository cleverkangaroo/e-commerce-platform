package com.kangaroo.microservices.provider.base.repository.master.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kangaroo.microservices.provider.base.dao.master.UsersMapper;
import com.kangaroo.microservices.provider.base.model.entity.Users;
import com.kangaroo.microservices.provider.base.repository.master.UsersRepository;
import com.kangaroo.microservices.provider.core.repository.impl.BaseRepositoryImpl;

import tk.mybatis.mapper.common.Mapper;

@Repository
public class UsersRepositoryImpl extends BaseRepositoryImpl<Users> implements UsersRepository{

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	protected Mapper<Users> getBaseMapper() {
		return usersMapper;
	}

	@Override
	public Users selectByUsernameAndDtype(String username, String dtype) {
		return usersMapper.selectByUsernameAndDtype(username, dtype);
	}

	
}
