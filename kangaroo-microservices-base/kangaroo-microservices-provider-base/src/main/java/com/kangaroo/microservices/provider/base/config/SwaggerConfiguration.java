package com.kangaroo.microservices.provider.base.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
@Profile({ "native", "dev", "test" })
public class SwaggerConfiguration {

	public static final String CONTROLLER_PACKAGE = "com.kangaroo.microservices";


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE)).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private List<Parameter> globalOperationParameters() {
		List<Parameter> p = new ArrayList<Parameter>();
		p.add(new ParameterBuilder()
				.modelRef(new ModelRef("string")).parameterType("header").required(false)
				.build());
		return p;
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("基础服务模块", "基础服务模块  RESTful APIs 文档</br>", "v1", "#", new Contact("", "", ""),
				"License for kangaroo", "#");
		return apiInfo;
	}
}
