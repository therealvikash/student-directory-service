package com.bma.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@Component
public class StudentDirectorySwaggerConfig {

	@Bean
	OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("StudentDirectory_V1").description(readSwaggerDocument().toString())
				.version("v1").license(new License().name("Student Directory Document")
						/*.url("https://github.com/adyant0208/student-directory")*/));
	}

	private StringBuilder readSwaggerDocument() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SCOPE: StudentDirectory_V1 api is a RESTful service that "
				+ "retrieves information about one or more student at a time"
				);
		return stringBuilder;
	}

}
