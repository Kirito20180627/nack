package com.ldy.common.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：李丹阳测试代码_接口文档")
                        .description("用于本地跑测试")
                        .contact(new Contact("li", null, null))
                        .version("版本号1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ldy.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
