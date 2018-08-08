package com.kangaroo.microservices.provider.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kangaroo.microservices.provider.base.model.entity.Users;
import com.kangaroo.microservices.provider.base.repository.master.UsersRepository;
import com.kangaroo.microservices.provider.base.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users selectByPrimaryKey(Long id) {
		return usersRepository.selectByPrimaryKey(id);
	}

	@Override
	public Users selectByUsernameAndDtype(String username, String dtype) {
		return usersRepository.selectByUsernameAndDtype(username, dtype);
	}
	
	
	
}
