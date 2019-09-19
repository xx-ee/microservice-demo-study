package com.microservice.service;


import com.microservice.common.BaseService;
import com.microservice.common.mapper.StudentMapper;
import com.microservice.common.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StudentServiceImpl extends BaseService implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getAll() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public Student queryByStuNo(String id) {
        return studentMapper.selectByIds(id).get(0);
    }
}
