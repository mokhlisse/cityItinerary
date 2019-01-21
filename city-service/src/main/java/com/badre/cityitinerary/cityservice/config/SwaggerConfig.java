package com.badre.cityitinerary.cityservice.config;

import static springfox.documentation.builders.PathSelectors.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.badre.cityitinerary.cityservice.controllers"))
				.paths(regex("/v1/city.*")).build();

	}

	@SuppressWarnings("unused")
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("City Service REST API")
				.description(
						"\"City Service REST API exposes the data related with a city defined with : city, destiny city, departure time, duration, stored in a data base\"")
				.version("0.0.1")
				// .license("Apache License Version 2.0")
				// .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact("Badre Edine Mokhlisse", "", "mokhlisse_badre@yahoo.fr"))
				.build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}