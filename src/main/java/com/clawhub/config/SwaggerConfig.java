package com.clawhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description> Swagger配置 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Description: 可以定义多个组 <br>
     *
     * @return docket
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Bean
    public Docket buildDocket() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("令牌，非必填").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add((Parameter) tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build().globalOperationParameters(pars);
    }

    /**
     * Description: ApiInfo <br>
     *
     * @return api info
     * @author LiZhiming <br>
     * @taskId <br>
     */
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("common").description("common").termsOfServiceUrl("NO terms of service").version("0.0.1").build();
    }

}