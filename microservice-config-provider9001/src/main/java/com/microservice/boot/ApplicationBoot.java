package com.microservice.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;

@ImportResource(locations = {"classpath:spring/*/*.xml"})
@MapperScan("com.microservice.common.mapper")
@Component("microservice-eureka")
@ComponentScan(
        basePackages = {"com.microservice.**"})
@Slf4j
@Configuration
@SpringBootApplication
public class ApplicationBoot {
    @PostConstruct
    public void start() {
        log.info("Microservice-provider ApplicationBoot");
    }
}