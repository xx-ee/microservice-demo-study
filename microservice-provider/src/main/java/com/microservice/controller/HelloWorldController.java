package com.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String home(String name) {
        return "hi "+name+",i am from port:" +port;
    }
}
