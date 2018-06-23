package com.kangaroo.api.management.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import com.kangaroo.api.management.cache.TokenKey;
import com.kangaroo.utils.redis.RedisHelper;

public class TokenAuthenticationFilter extends GenericFilterBean {
	public static final String HEADER_TOKEN = "token";

	private RedisHelper redisHelper;

	public TokenAuthenticationFilter(RedisHelper redisHelper) {
		this.redisHelper = redisHelper;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		verifyToken(httpRequest, httpResponse);
		chain.doFilter(request, response);
		return;
	}

	private void verifyToken(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
		String token = getToken(httpRequest);
		if (StringUtils.isEmpty(token)) {
			return;
		}
		Long userid = redisHelper.opsForLong().get(token, TokenKey.TOKEN);
		if (userid==null) {
			return;
		}
		CustomUserDetails userDetails = new CustomUserDetails(userid, "", "", new ArrayList<GrantedAuthority>());
		Authentication securityToken = new PreAuthenticatedAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(securityToken);
		return;
	}

	private String getToken(HttpServletRequest httpRequest) {
		String token = httpRequest.getHeader(HEADER_TOKEN);
		if (StringUtils.isEmpty(token)) {
			token = httpRequest.getParameter(HEADER_TOKEN);
		}
		return token;
	}
}
