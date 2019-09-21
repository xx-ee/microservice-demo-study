package com.microservice.controller;

import com.microservice.common.model.Student;
import com.microservice.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {
    @Value("${server.port}")
    String port;

    @Autowired
    private DiscoveryClient client;//服务发现

    @Autowired(required = false)
    private StudentService studentService;

    @RequestMapping("/hello")
    public String home(String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    //服务发现，查询该provider信息
    @RequestMapping("/hello/discovery")
    public Object getHelloInfo()
    {
        List<String> services = client.getServices();
        System.out.println("*********"+services);
        List<ServiceInstance> instances = client.getInstances("microservice-provider-test");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.client;
    }

    @RequestMapping("/provider/all")
    public List<Student> getAllStudents()
    {
        return studentService.getAll();
    }

    @RequestMapping("provider/get/{id}")
    //一旦调用服务失败并抛出了异常错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_queryById")
    public Student queryById(@PathVariable String id)
    {
        Student student = studentService.queryByStuNo(id);
        if (null==student)
        {
            throw new RuntimeException("该id"+id+"没有对应的信息");
        }
        return student;
    }

    public Student processHystrix_queryById(@PathVariable("id") String id)
    {
        Student temp = new Student();
        temp.setStuNo(id);
        temp.setStuName("该ID："+id+"没有对应的信息，null--@HystrixCommand");
        temp.setDbSource("no this database in MySQL");
        temp.setStuClass("该ID"+id+"没有对应班级信息");
        return temp;
    }
}
