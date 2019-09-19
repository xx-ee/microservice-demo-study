package com.microservice.service;

import com.microservice.common.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student queryByStuNo(String id);
}
