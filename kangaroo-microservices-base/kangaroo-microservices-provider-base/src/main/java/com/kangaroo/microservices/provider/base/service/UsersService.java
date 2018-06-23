package com.kangaroo.microservices.provider.base.service;

import com.kangaroo.microservices.provider.base.model.entity.Users;

public interface UsersService {

	public Users selectByPrimaryKey(Long id);
	
	public Users selectByUsernameAndDtype(String username, String dtype);
}
