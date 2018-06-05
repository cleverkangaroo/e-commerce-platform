package com.kangaroo.microservices.provider.core.exception;

import com.kangaroo.core.exception.ErrorMessageEnum;

public class BasicErrorMessage implements ErrorMessageEnum{
	private Integer code;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setErrorMessage(ErrorMessageEnum errorMessageEnum) {
		this.code = errorMessageEnum.getCode();
		this.message = errorMessageEnum.getMessage();
	}
}
