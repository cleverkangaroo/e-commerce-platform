package com.kangaroo.api.management.support;

public enum ReturnStatusEnum {
	SUCCESS(200, "ok"), UNAUTHENTICATION(202, "unauthentication"), ERROR(201, "服务器内部错误");
	
	private Integer code;

	private String message;

	private ReturnStatusEnum(Integer code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		if (this.code==null) {
			return "";
		}
		return String.valueOf(this.code);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


}