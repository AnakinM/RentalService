package com.anikiej.rentalservice;

import com.anikiej.rentalservice.utils.CustomResponseErrorHandler;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class AppConfig {

    private final CustomResponseErrorHandler customResponseErrorHandler;

    @Autowired
    public AppConfig(CustomResponseErrorHandler customResponseErrorHandler) {
        this.customResponseErrorHandler = customResponseErrorHandler;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(customResponseErrorHandler);
        return restTemplate;
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI().info(new Info()
                .title("Rental API")
                .version(appVersion)
                .description("A documentation of Rental Service app")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.org")));
    }

}

