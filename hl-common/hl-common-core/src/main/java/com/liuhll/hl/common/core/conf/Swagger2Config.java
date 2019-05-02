package com.liuhll.hl.common.core.conf;

import com.google.common.collect.Lists;
import com.liuhll.hl.common.auth.conf.SecurityWhitelistConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

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

    @Value("${swagger.controller-package-name}")
    private String controllerPackageName;

    @Value("${jwt.header:Authorization}")
    private String authorizationHeader;

    @Autowired
    private SecurityWhitelistConfig whitelistConfig;

    @Bean
    public Docket getApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(controllerPackageName))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enable(enable)
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Lists.newArrayList(securityContext()))
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(appTitle)
                .description(appDesc)
                .version(appVersion)
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/**/api/**"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", authorizationHeader, "header");
    }

//    private SecurityScheme oauth() {
//        return new OAuthBuilder()
//                .name("oauth2")
//                .scopes(scopes())
//                .grantTypes(grantTypes())
//                .build();
//    }
//    private List<AuthorizationScope> scopes() {
//        List<AuthorizationScope> list = new ArrayList();
//        list.add(new AuthorizationScope("read", "Grants read access"));
//        list.add(new AuthorizationScope("write", "Grants write access"));
//        return list;
//    }
//
//    @Bean
//    List<GrantType> grantTypes() {
//        String tokenUrl = "/oauth/token", authorizeUrl = "/oauth/authorize", loginUrl = "/login";
//        List<GrantType> grantTypes = new ArrayList<>();
//        ClientCredentialsGrant clientCredentialsGrant = new ClientCredentialsGrant(tokenUrl);
//        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant =
//                new ResourceOwnerPasswordCredentialsGrant(tokenUrl);
//        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(new TokenRequestEndpoint(authorizeUrl
//                , "clientId", "clientSecret"), new TokenEndpoint(tokenUrl, "Authorization"));
//        ImplicitGrant implicitGrant = new ImplicitGrant(new LoginEndpoint(tokenUrl), "");
//        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
//        grantTypes.add(implicitGrant);
//        grantTypes.add(authorizationCodeGrant);
//        grantTypes.add(clientCredentialsGrant);
//        return grantTypes;
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.ant("/**/api/**"))//配置哪些url需要做oauth2认证
//                .build();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        return Lists.newArrayList(
//                new SecurityReference("oauth2", scopes().toArray(new AuthorizationScope[0])));
//    }
}
