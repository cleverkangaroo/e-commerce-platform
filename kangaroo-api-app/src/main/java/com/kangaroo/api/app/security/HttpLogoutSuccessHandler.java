package com.kangaroo.api.app.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import com.kangaroo.api.app.support.ApiResult;
import com.kangaroo.api.app.cache.TokenKey;
import com.kangaroo.api.app.security.TokenAuthenticationFilter;
import com.kangaroo.utils.json.FastJsonUtil;
import com.kangaroo.utils.redis.RedisHelper;

@Component
public class HttpLogoutSuccessHandler implements LogoutSuccessHandler, InitializingBean {
	private String logoutResult;
	@Autowired
	private RedisHelper redisHelper;

	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		logout(request, response, authentication);
		SecurityContextHolder.clearContext();
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().write(logoutResult);
		response.getWriter().flush();
	}

	private void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		String token = request.getHeader(TokenAuthenticationFilter.HEADER_TOKEN);
		if (StringUtils.isEmpty(token)) {
			return;
		}
		redisHelper.del(token, TokenKey.TOKEN);
	}

	public void afterPropertiesSet() throws Exception {
		logoutResult = FastJsonUtil.toJSONString(ApiResult.success);
	}
}