package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
//    private static final String REST_URL_PREFIX="http://localhost:9001";
    private static final String REST_URL_PREFIX="http://MICROSERVICE-PROVIDER";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/hello/discovery")
    public Object disCovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/hello/discovery",Object.class);
    }

    @RequestMapping("/consumer/get/all")
    public List<Object> getAll()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/provider/all",List.class);

    }
    @RequestMapping("/consumer/get/{id}")
    public Object getObject(@PathVariable("id") String id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/provider/get/"+id,Object.class);
    }
}
