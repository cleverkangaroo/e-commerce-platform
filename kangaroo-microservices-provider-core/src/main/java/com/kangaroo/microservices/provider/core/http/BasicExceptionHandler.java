package com.kangaroo.microservices.provider.core.http;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

public class BasicExceptionHandler {
	private static final int DEFAULT_MAX_PAYLOAD_LENGTH = 1024;

	protected String createMessage(HttpServletRequest request, String prefix, String suffix) {
		StringBuilder msg = new StringBuilder();
		msg.append(prefix);
		msg.append("uri=").append(request.getRequestURI());

		String queryString = request.getQueryString();
		if (queryString != null) {
			msg.append('?').append(queryString);
		}

		String client = request.getRemoteAddr();
		if (StringUtils.hasLength(client)) {
			msg.append(";client=").append(client);
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			msg.append(";session=").append(session.getId());
		}
		String user = request.getRemoteUser();
		if (user != null) {
			msg.append(";user=").append(user);
		}

		msg.append(";headers=").append(new ServletServerHttpRequest(request).getHeaders());

		ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
		if (wrapper != null) {
			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = Math.min(buf.length, getDefaultMaxPayloadLength());
				String payload;
				try {
					payload = new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					payload = "[unknown]";
				}
				msg.append(";payload=").append(payload);
			}
		}

		msg.append(suffix);
		return msg.toString();
	}

	public int getDefaultMaxPayloadLength() {
		return DEFAULT_MAX_PAYLOAD_LENGTH;
	}
}
