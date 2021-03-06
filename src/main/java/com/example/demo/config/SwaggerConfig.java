package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger Deneme")
                .version("1.0.0").build();
    }

    @Bean
    public Docket customImplementation(){
       return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .apiInfo(apiInfo())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);

        /*return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();*/
    }

}
