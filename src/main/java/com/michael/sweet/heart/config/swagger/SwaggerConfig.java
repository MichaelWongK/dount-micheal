package com.michael.sweet.heart.config.swagger;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

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
        ArrayList<ResponseMessage> responseMessageList = Lists.newArrayList();
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求参数有误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("用户无权限,请获取权限认证").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)

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
