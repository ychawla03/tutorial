package com.example.Mappings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	            .info(new Info()
	                .title("User-Profile Relationship")
	                .version("1.0")
	                .description("This is a sample API for User Profile Storage")
	                .contact(new Contact().name("Author Name").
	                		email("a.b@gmail.com")));
	}
	
}

//Check this url
//http://localhost:8080/swagger-ui/index.html
//http://localhost:8091/swagger-ui/index.html
//Click Try out and on swagger page - you can test your restful endpoints