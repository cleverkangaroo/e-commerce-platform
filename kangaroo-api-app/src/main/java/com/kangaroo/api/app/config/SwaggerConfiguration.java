package com.kangaroo.api.app.config;

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

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = "kangaroo.swagger.enable", havingValue = "true")
public class SwaggerConfiguration {

	public static final String CONTROLLER_PACKAGE = "com.kangaroo.api";
	public static final String TOEKN = "token";
	public static final String TOKEN_DESCR="用户token";
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE)).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).globalOperationParameters(globalOperationParameters());
	}

	private List<Parameter> globalOperationParameters() {
		List<Parameter> p = new ArrayList<Parameter>();
		p.add(new ParameterBuilder().name(TOEKN).description(TOKEN_DESCR)
				.modelRef(new ModelRef("string")).parameterType("header").required(true)
				.defaultValue("").build());

		return p;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("app", "app  RESTful APIs 文档</br>", "", "#", new Contact("", "", ""),
				"License for kangaroo", "#");
		return apiInfo;
	}
}
