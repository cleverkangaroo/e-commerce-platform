package com.kangaroo.api.management.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = "kangaroo.swagger.enable", havingValue = "true")
public class SwaggerConfiguration {

	public static final String CONTROLLER_PACKAGE = "com.kangaroo.api";

	
	public static final String TOEKN = "token";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE)).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo())
				//.globalOperationParameters(globalOperationParameters());
				;
	}

	private List<Parameter> globalOperationParameters() {
		List<Parameter> p = new ArrayList<Parameter>();
		p.add(new ParameterBuilder().name(TOEKN)
				.modelRef(new ModelRef("string")).parameterType("header").required(true)
				.defaultValue("").build());

		return p;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("管理平台", "管理平台  RESTful APIs 文档</br>", "v37", "#", new Contact("", "", ""),
				"License for kangaroo", "#");
		return apiInfo;
	}
}
