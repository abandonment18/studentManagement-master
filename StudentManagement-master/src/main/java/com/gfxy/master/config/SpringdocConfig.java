package com.gfxy.master.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("学生管理系统")
                        .description("学生管理系统在线API")
                        .version("1.0.0")
                        .license(new License().name("十四夜").url("http://shisiye.top")));
    }
}
