package com.example.Hotel_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class HotelDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelDemoApplication.class, args);
	}

	@Bean
	public Docket docket()
	{
	ApiInfoBuilder builder = new ApiInfoBuilder();
	builder.title("Hotel Rest api document");
	builder.version("1.1");
	builder.description("used to perform crud operation on hotels");
	builder.license("Estuate");
	builder.licenseUrl("http://www.google.com");
	ApiInfo apiInfo= builder.build();

	return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.example.Hotel_Demo"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo);
	}

}
