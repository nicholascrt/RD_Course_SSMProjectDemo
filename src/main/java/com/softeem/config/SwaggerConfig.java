package com.softeem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @project_name: com.softeem.config
 * @description: Swagger配置类
 * @author: Nicholas Chen
 * @time: 13/02/2021 5:42 PM
 * @version: v1.0
 */
@Configuration //注明是配置类
@EnableSwagger2 //开启Swagger
@ComponentScan(basePackages = {"com.softeem.controller"}) //代表扫描此包下的所有类
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select() //选择那些路径和API会生成Document
                //basePackage扫描包
                //.apis(RequestHandlerSelectors.basePackage("com.softeem.controller"))
                //withMethodAnnotation扫描方法注解
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //any扫描所有api,没有注解也可以扫描出来
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 自定义ApiInfo
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                    //大标题
                    .title("软帝OA项目接口文档")
                    //描述
                    .description("API接口测试")
                    //版本
                    .version("v1.0.0")
                    .license("").licenseUrl("").termsOfServiceUrl("").build();
    }
}
