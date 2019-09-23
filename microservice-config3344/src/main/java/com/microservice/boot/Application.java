package com.microservice.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;
@ImportResource(locations = {"classpath:spring/*/*.xml"})
@ComponentScan(
        basePackages = {"com.microservice.**"})
@Slf4j
@Configuration
@SpringBootApplication
public class Application {
    @PostConstruct
    public void start() {
        log.info("Config-Server ApplicationBoot");
    }
}
