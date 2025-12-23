package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("InsuredProcess API")
                        .version("1.0")
                        .description("API documentation for InsuredProcess application")
                        .contact(new Contact().name("API Support").email("support@example.org"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}

