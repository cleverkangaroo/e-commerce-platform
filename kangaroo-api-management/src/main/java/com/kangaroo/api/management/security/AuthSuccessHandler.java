package com.kangaroo.api.management.security;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.kangaroo.api.management.cache.TokenKey;
import com.kangaroo.api.management.support.ApiResult;
import com.kangaroo.microservices.api.base.service.UsersService;
import com.kangaroo.utils.json.FastJsonUtil;
import com.kangaroo.utils.redis.RedisHelper;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private RedisHelper redisHelper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		
		String token = UUID.randomUUID().toString();
		// 记录token
		redisHelper.opsForLong().set(token, userDetails.getUserid(), TokenKey.TOKEN);
		String result = FastJsonUtil.toJSONString(ApiResult.ok(token));
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().write(result);
		response.getWriter().flush();
	}

}