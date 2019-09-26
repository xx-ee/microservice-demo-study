package com.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${spring.application.name}")
    private String applicationname;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServsers;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/config")
    public String getConfig()
    {
        System.out.println("applicationName:"+applicationname);
        System.out.println("eurekaServers:"+eurekaServsers);
        System.out.println("port:"+port);
        return "应用名:"+applicationname+"\r\n"+"\r\n注册中心列表:"+eurekaServsers+"\r\n"+"\r\n端口号:"+"\t"+port;
    }
}
