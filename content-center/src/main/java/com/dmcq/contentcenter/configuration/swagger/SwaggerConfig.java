package com.dmcq.contentcenter.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


/**
 * @description: Swagger2 配置
 * @author: qinhao25
 * @time: 2020/1/20 18:48
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket controllerApi() {
        // 添加token输入框
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("Auth-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("内容中心API")
                        .description("内容中心")
                        .termsOfServiceUrl("https://github.com/qinpiyi")
                        .version("1.0.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dmcq.contentcenter.web"))
                .paths(PathSelectors.any())
                //.build();
                .build().globalOperationParameters(pars);

    }
}
