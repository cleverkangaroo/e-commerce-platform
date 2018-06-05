package com.kangaroo.microservices.provider.core.exception;

import java.text.MessageFormat;

import com.kangaroo.core.exception.ErrorMessageEnum;

public class BasicException extends RuntimeException {
	private static final long serialVersionUID = 7887316089838342558L;
	private final Integer code;
	private final String msg;

	public BasicException(ErrorMessageEnum errorMessage, Throwable cause) {
		super(errorMessage.getMessage(), cause);
		this.code = errorMessage.getCode();
		this.msg = errorMessage.getMessage();
	}

	public BasicException(ErrorMessageEnum errorMessage, Throwable cause, Object... arguments) {
		super(errorMessage.getMessage(), cause);
		this.code = errorMessage.getCode();
		this.msg = MessageFormat.format(errorMessage.getMessage(), arguments);
	}

	public BasicException(ErrorMessageEnum errorMessage) {
		super(errorMessage.getMessage(), null);
		this.code = errorMessage.getCode();
		this.msg = errorMessage.getMessage();
	}

	public BasicException(ErrorMessageEnum errorMessage, Object... arguments) {
		this(errorMessage, null, arguments);
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
