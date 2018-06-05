package com.kangaroo.utils.json;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();

	protected static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);

	
	public static String objectToJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static <T> T jsonToObject(String str, Class<T> T) {
		try {
			return objectMapper.readValue(str, T);
		} catch (JsonParseException e) {
			LOG.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}


	public static Object jsonToObject(String str, Class<?> collectionClass, Class<?>... elementClasses) {
		JavaType type = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		try {
			return objectMapper.readValue(str, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToList(String str, Class<T>... elementClasses) {
		JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, elementClasses);
		try {
			return objectMapper.readValue(str, type);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return Collections.emptyList();
	}

	
	public static Object jsonToObject(String str, TypeReference<?> type) {
		try {
			return objectMapper.readValue(str, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
