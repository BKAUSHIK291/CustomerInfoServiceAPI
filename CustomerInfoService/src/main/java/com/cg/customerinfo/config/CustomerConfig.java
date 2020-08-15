package com.cg.customerinfo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class CustomerConfig {
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/customer/*"))
				.build()
				.apiInfo(apiDetails());
	}
	
	public ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Customer Info API", 
				"One step Customer API", 
				"1.1", 
				"Open Source", 
				new Contact("Kaushik Bhattacharya", "www.kbc.com", "abc@xyz.com"), 
				"API License v7.8", 
				"www.myfirstapi.com",
				Collections.emptyList());
	}

}
