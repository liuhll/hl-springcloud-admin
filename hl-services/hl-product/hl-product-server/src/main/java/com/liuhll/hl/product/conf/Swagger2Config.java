package com.liuhll.hl.product.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket getApis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuhll.hl.product.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                ;
    }

    private ApiInfo getApiInfo()
    {
        return new ApiInfoBuilder()
                .title("product server app component")
                .description("product server api docs")
                .version("v1.0.0")
                .build();
    }


}
