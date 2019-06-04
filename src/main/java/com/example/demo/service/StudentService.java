package com.example.demo.service;


import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;


    @Transactional(rollbackFor = RuntimeException.class)
    public void updateStudentName(String name, int id){
        studentMapper.updateStudentName(name, id);
        throw new RuntimeException("323");

    }

}
