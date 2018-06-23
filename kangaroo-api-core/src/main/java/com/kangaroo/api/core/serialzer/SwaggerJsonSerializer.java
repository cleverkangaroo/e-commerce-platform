package com.kangaroo.api.core.serialzer;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import springfox.documentation.spring.web.json.Json;

public class SwaggerJsonSerializer implements ObjectSerializer{

	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		SerializeWriter out = serializer.getWriter();
	    Json json = (Json)object;
	    out.write(json.value());
		
	}

}
