package com.microservice.service;

import com.microservice.common.model.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConsumerClientServiceFallbackFactory implements FallbackFactory<ConsumerClientService> {
    @Override
    public ConsumerClientService create(Throwable throwable) {

        return new ConsumerClientService() {
            @Override
            public List<Student> getAllStudents() {
                return null;
            }

            @Override
            public Student queryById(String id) {
                Student temp = new Student();
                temp.setStuNo(id);
                temp.setStuName("该ID："+id+",consumer客户端提供的服务降级，此刻服务provider已经关闭！");
                temp.setDbSource("provider is down....");
                temp.setStuClass("该ID:"+id+",没有对应班级信息，提供服务降级");
                return temp;
            }
        };
    }
}
