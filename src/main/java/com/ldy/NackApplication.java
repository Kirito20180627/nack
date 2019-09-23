package com.ldy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties
@EnableSwagger2
public class NackApplication {
    public static void main(String[] args) {
        SpringApplication.run(NackApplication.class, args);
    }
}
