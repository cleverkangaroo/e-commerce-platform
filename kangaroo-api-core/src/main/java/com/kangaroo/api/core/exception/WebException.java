package com.kangaroo.api.core.exception;

public class WebException
extends RuntimeException
{
private static final long serialVersionUID = 393628634969901413L;
private final Integer code;
private final String msg;



public WebException(Integer code, String message) {
	super(message);
	this.code = code;
	this.msg = message;
}

public WebException(Integer code, String message, Throwable cause) {
	super(message,cause);
	this.code = code;
	this.msg = message;
}
public Integer getCode()
{
  return this.code;
}

public String getMsg()
{
  return this.msg;
}
}