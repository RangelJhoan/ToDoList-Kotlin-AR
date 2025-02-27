package com.rangeljhoandev.todolist

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("To Do List API REST with Spring Boot 3 documentation")
                    .version("0.1")
                    .description("API REST application for manage task list")
                    .termsOfService("http://swagger.io/terms")
                    .license(
                        License()
                            .name("Apache 2.0")
                            .url("http://springdoc.org")
                    )
            )
    }

}