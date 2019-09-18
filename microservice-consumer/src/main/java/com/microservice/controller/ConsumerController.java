package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    private static final String REST_URL_PREFIX="http://localhost:9001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/hello/discovery")
    public Object disCovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/hello/discovery",Object.class);
    }
}
