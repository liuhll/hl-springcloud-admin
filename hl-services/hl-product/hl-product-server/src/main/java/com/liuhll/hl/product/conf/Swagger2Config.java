package com.liuhll.hl.product.conf;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

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
                .pathProvider(relativeSwaggerPathProvider())
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

    @Autowired
    private ServletContext servletContext;

    @Bean
    public AbstractPathProvider relativeSwaggerPathProvider() {
        return new ApiRelativeSwaggerPathProvider(servletContext);
    }


    private class ApiRelativeSwaggerPathProvider extends RelativePathProvider {
        public static final String ROOT = "/";
        private final ServletContext servletContext;

        public ApiRelativeSwaggerPathProvider(ServletContext servletContext) {
            super(servletContext);
            this.servletContext = servletContext;
        }

        protected String applicationPath() {
            return Strings.isNullOrEmpty(this.servletContext.getContextPath()) ? "/" : this.servletContext.getContextPath();
        }

        protected String getDocumentationPath() {
            // return "/";
            return Strings.isNullOrEmpty(this.servletContext.getContextPath()) ? "/" : this.servletContext.getContextPath();
        }
    }


    @Bean
    UiConfiguration uiConfig() {
        UiConfiguration uiConfiguration = UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.LIST)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(true)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl("/")
                .build();

        return uiConfiguration;
    }


}
