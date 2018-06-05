package com.kangaroo.microservices.provider.core.exception;

import com.kangaroo.core.exception.ErrorMessageEnum;

public enum BasicSystemErrorMessage implements ErrorMessageEnum {
	INTERNAL_SERVER_ERROR(500, "服务器内部错误");

	private Integer code;
	private String message;

	BasicSystemErrorMessage(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
