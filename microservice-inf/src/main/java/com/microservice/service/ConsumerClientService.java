package com.microservice.service;

import com.microservice.common.model.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@FeignClient(value = "MICROSERVICE-PROVIDER")
//服务降级
@FeignClient(value = "MICROSERVICE-PROVIDER",fallbackFactory = ConsumerClientServiceFallbackFactory.class)
public interface ConsumerClientService
{
    @RequestMapping("provider/all")
    public List<Student> getAllStudents();

    @RequestMapping("provider/get/{id}")
    public Student queryById(@PathVariable("id") String id);
}
