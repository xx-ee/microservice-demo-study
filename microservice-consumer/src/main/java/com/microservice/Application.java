package com.microservice;

import com.microservice.boot.ApplicationBoot;
import com.rules.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
//在启动该微服务的时候去加载我们的自定义Ribbon配置类，从而使配置类生效
@RibbonClient(name="MICROSERVICE-PROVIDER",configuration = MySelfRule.class)
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
