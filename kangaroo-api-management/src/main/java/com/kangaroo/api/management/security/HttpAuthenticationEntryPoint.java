package com.kangaroo.api.management.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.kangaroo.api.management.support.ApiResult;
import com.kangaroo.api.management.support.ReturnStatusEnum;
import com.kangaroo.utils.json.FastJsonUtil;

@Component
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint, InitializingBean {
	private String unloginResult;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().write(unloginResult);
		response.getWriter().flush();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		ApiResult result = new ApiResult(ReturnStatusEnum.UNAUTHENTICATION, "未登陆");
		unloginResult = FastJsonUtil.toJSONString(result);
	}
}