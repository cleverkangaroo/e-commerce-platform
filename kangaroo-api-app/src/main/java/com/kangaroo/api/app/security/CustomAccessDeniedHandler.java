package com.kangaroo.api.app.security;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		CustomAccessDeniedException exception = (CustomAccessDeniedException) accessDeniedException;
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter()
				.write("{\"status\":208,\"msgCode\":" + exception.getMsgCode() + ",\"msg\":\"" + exception.getMsgStr() + "\"}");
		response.getWriter().flush();
	}
}
