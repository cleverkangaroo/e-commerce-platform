package com.kangaroo.api.management.support;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回结果")
public class ApiResult {

	public final static ApiResult success = new ApiResult(ReturnStatusEnum.SUCCESS, null, Boolean.TRUE);
	public final static ApiResult fail = new ApiResult(ReturnStatusEnum.ERROR, null, Boolean.TRUE);
	@ApiModelProperty(value = "状态码")
	private ReturnStatusEnum status;
	@ApiModelProperty(value = "状态信息")
	private String msg;
	@ApiModelProperty(value = "返回的数据")
	private Object data;

	public ApiResult() {
	}

	public ApiResult(ReturnStatusEnum status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public ApiResult(ReturnStatusEnum status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	@JSONField(name="status")
	public Integer getStatus() {
		return status.getCode();
	}
	

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		if (StringUtils.isBlank(msg)) {
			return status.getMessage();
		}
		return msg;
	}

	public Object getData() {
		return data;
	}

	public static ApiResult build() {
		return new ApiResult();
	}

	public static ApiResult ok() {
		return new ApiResult(ReturnStatusEnum.SUCCESS, null);
	}

	public static ApiResult ok(Object data) {
		return new ApiResult(ReturnStatusEnum.SUCCESS, null, data);
	}

}
