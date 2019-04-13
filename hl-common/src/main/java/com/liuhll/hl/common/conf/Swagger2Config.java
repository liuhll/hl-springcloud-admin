package com.liuhll.hl.common.conf;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${swagger.title}")
    private String appTitle;

    @Value("${swagger.description}")
    private String appDesc;

    @Value("${swagger.version}")
    private String appVersion;

    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket getApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuhll.hl.product.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enable(enable)
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(appTitle)
                .description(appDesc)
                .version(appVersion)
                .build();
    }
}
