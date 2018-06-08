package com.kangaroo.microservices.provider.base.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.kangaroo.microservices.provider.base.support.DefaultHandlerInterceptor;
import com.kangaroo.microservices.provider.core.swagger.SwaggerJsonSerializer;
import com.kangaroo.utils.spring.EnvUtil;

import springfox.documentation.spring.web.json.Json;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter();
		stringHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(stringHttpMessageConverter);
		
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		MediaType mediaType_Json = MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE);
		supportedMediaTypes.add(mediaType_Json);
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.getSerializeConfig().put(Json.class, new SwaggerJsonSerializer());
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastJsonHttpMessageConverter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/swagger-resources/**")
				.addResourceLocations("classpath:/META-INF/swagger-resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new DefaultHandlerInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("swagger-ui.html", "/webjars/**", "/swagger-resources/**");
	}


	
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
	    return new MethodValidationPostProcessor();
	}
	
	@Bean
	public EnvUtil envUtil() {
		return new EnvUtil();
	}
}
