package com.kangaroo.api.management.support;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class ApiResultSerializer implements ObjectSerializer {

	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		SerializeWriter out = serializer.getWriter();
		if (object == null) {
			out.writeNull();
			return;
		}
		ApiResult result = (ApiResult) object;
		out.write('{');
		out.writeFieldName("msg");
		out.writeString(result.getMsg());
		out.write(',');
		out.writeFieldName("status");
		out.writeInt(result.getStatus());
		out.write(',');
		out.writeFieldName("data");
		serializer.write(result.getData());
		out.write('}');
	}

}
