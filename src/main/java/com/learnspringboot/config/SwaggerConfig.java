package com.learnspringboot.config;



import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @ClassName SwaggerConfig
 * @Author User
 * @date 2021.03.02 14:58
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {
    // swagger开关，开发环境开启，生产环境关闭
    @Value("${knife4j.enabled}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                .enable(enableSwagger)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.learnspringboot.controller"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @Description swagger基本信息
     * @Param
     * @return
     * @Author zhen.ma
     * @Date 2021.03.02 15:01
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("Person管理系统Restful Api文档")
                //文档描述
                .description("接口说明")
                //服务条款URL
                .termsOfServiceUrl("http://127.0.0.1:9002/")
                //联系信息
                .contact(new Contact("zhen.ma","http://raspberryvip.wicp.vip","15291831100@163.com"))
                //版本号
                .version("v20210302")
                .build();
    }
}

