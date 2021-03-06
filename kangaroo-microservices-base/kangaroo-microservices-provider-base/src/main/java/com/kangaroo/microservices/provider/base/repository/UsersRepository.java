package com.kangaroo.microservices.provider.base.repository;

import com.kangaroo.microservices.provider.base.model.entity.Users;
import com.kangaroo.microservices.provider.core.repository.BaseRepository;

public interface UsersRepository extends BaseRepository<Users>{

	public Users selectByUsernameAndDtype(String username,String dtype);
}
