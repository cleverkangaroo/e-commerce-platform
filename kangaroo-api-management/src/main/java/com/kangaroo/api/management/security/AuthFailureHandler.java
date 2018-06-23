package com.kangaroo.api.management.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.kangaroo.api.management.support.ApiResult;
import com.kangaroo.api.management.support.ReturnStatusEnum;
import com.kangaroo.utils.json.FastJsonUtil;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		ApiResult result = new ApiResult(ReturnStatusEnum.ERROR,"登陆失败");

		if (exception instanceof UsernameNotFoundException) {
			result.setMsg("用户名不对");
		} else if (exception instanceof BadCredentialsException) {
			result.setMsg("密码不对");
		}
		
		String error = FastJsonUtil.toJSONString(result);
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().write(error);
		response.getWriter().flush();
	}
}