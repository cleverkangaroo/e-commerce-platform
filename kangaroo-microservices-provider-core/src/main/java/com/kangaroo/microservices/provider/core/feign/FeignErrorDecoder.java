package com.kangaroo.microservices.provider.core.feign;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kangaroo.microservices.provider.core.exception.BasicErrorMessage;
import com.kangaroo.microservices.provider.core.exception.BasicException;
import com.kangaroo.microservices.provider.core.exception.BasicSystemErrorMessage;
import com.kangaroo.utils.json.FastJsonUtil;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Exception decode(String methodKey, Response response) {
		try {
			String body = Util.toString(response.body().asReader());
			if (response.status() == 400) {
				BasicErrorMessage webErrorMessage = FastJsonUtil.toBean(body, BasicErrorMessage.class);
				return new BasicException(webErrorMessage);
			} else {
				logger.error("{} , 接口调用错误 , api状态码为{} , api返回body为{}", methodKey, response.status(), body);
				return new BasicException(BasicSystemErrorMessage.INTERNAL_SERVER_ERROR);
			}
		} catch (IOException e) {
			logger.error("{} , 接口调用错误 , api状态码为{} , 错误信息为:{}", methodKey, response.status(), e);
			return new BasicException(BasicSystemErrorMessage.INTERNAL_SERVER_ERROR);
		}
	}
}
