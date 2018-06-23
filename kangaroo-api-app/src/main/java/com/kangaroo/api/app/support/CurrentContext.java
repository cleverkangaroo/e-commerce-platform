package com.kangaroo.api.app.support;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.kangaroo.api.app.security.CustomUserDetails;
import com.kangaroo.api.core.exception.WebException;
import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.api.base.service.UsersService;

@Component
public class CurrentContext {
	private static final ThreadLocal<String> ip = new ThreadLocal<String>();


	private static UsersService usersService;

	@Autowired
	public CurrentContext(UsersService usersService) {
		CurrentContext.usersService = usersService;
	}

	public static Long getUserId() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return null;
		}
		Authentication auth = context.getAuthentication();
		if (auth == null) {
			return null;
		}
		Object user = auth.getPrincipal();
		if (user instanceof CustomUserDetails) {
			return ((CustomUserDetails)user).getUserid();
		} else {
			return null;
		}
	}

	public static UsersVO getUserInfo() {
		UsersVO usersVO  = usersService.getUserInfo(getUserId());
		if (Objects.isNull(usersVO)) {
			throw new WebException(206,"用户不存在");
		}
		return usersVO;
	}

	public static String getIp() {
		return ip.get();
	}

	public static void setIp(String value) {
		ip.set(value);
	}

	public static void clearIp() {
		ip.remove();
	}


}
