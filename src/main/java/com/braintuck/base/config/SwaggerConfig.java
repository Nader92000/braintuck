package com.braintuck.base.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import org.springframework.context.annotation.Configuration;


/**
 * @author GhofranAbdelwahab
 * @Date 06 Dec 2022
 **/
@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "BrainTuck API Documentation"))
@io.swagger.v3.oas.annotations.security.SecurityScheme(name = "Bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class SwaggerConfig {

}