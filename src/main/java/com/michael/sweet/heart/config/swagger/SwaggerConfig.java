package com.michael.sweet.heart.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * DESCRIPTION: Swagger基础配置， TODO Swagger接口授权使用oauth2  ? token 具体授权方式待定
 *
 * @param
 * @return
 * @author mingkai <a href="mailto:wangmk.wang@xiaoi.com"/>
 * @date
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.michael.sweet.heart.platform"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SWEET-HEART")
                .description("springboot for sweetheart 授权方式待定")
                .version("0.0.1")
                .build();
    }
}
