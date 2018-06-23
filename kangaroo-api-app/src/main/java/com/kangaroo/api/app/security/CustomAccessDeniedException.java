package com.kangaroo.api.app.security;

import org.springframework.security.access.AccessDeniedException;

public class CustomAccessDeniedException extends AccessDeniedException {

	private static final long serialVersionUID = -2313112565776344834L;

	private Integer msgCode;
	private String msgStr;

	public CustomAccessDeniedException(String msg, Integer msgCode, String msgStr) {
		super(msg);
		this.msgCode = msgCode;
		this.msgStr = msgStr;
	}

	public Integer getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(Integer msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgStr() {
		return msgStr;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

}
