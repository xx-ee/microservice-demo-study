package com.microservice;

import com.microservice.boot.ApplicationBoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@ImportResource(locations = {"classpath:spring/*/*.xml"})
//@MapperScan("com.microservice.common.mapper")
//@Component("microservice-eureka")
//@Configuration
//@SpringBootApplication(scanBasePackages = {"com.microservice.**","com.microservice.service"})
@SpringBootApplication
@Slf4j
@EnableEurekaClient     //本服务启动后自动注册到eureka服务中
@EnableZuulProxy
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
