package com.microservice;

import com.microservice.boot.ApplicationBoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ApplicationBoot.class, args);
        } catch (Throwable t) {
            log.error("启动失败", t);
            throw t;
        }
    }
}
