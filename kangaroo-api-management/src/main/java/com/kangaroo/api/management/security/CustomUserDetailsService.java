package com.kangaroo.api.management.security;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.api.base.service.UsersService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UsersService usersService;

	private static String DTYPE = "Business";

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO usersVO = usersService.selectByUsernameAndDtype(username, DTYPE);
		if (Objects.isNull(usersVO)) {
			throw new UsernameNotFoundException("username not found");
		}
		return new CustomUserDetails(usersVO.getId(), usersVO.getUsername(), usersVO.getEncodedpassword(),
				new ArrayList<GrantedAuthority>());
	}
}