package com.kangaroo.api.management.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.kangaroo.api.core.serialzer.SwaggerJsonSerializer;
import com.kangaroo.api.management.support.ApiResult;
import com.kangaroo.api.management.support.ApiResultSerializer;

import springfox.documentation.spring.web.json.Json;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Value("${cors.allowed-origins}")
	private String origins;
	
	
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ByteArrayHttpMessageConverter byteArrayHttpMessageConverter=new ByteArrayHttpMessageConverter();
		converters.add(byteArrayHttpMessageConverter);
		
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
		fastJsonConfig.getSerializeConfig().put(ApiResult.class,new ApiResultSerializer());
		
		
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.PrettyFormat,
				SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullNumberAsZero);
		
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
	public Validator getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
		return localValidatorFactoryBean;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin(origins);
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
