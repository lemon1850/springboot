package com.example.demo.service;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class FooService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;



    public void updateClassName(String className, int id ){
        System.out.println("更新班集体名字");
        classMapper.updateClassName(className, id);
    }
    public void updateStudent(String name, int id ){
        System.out.println("更新学生");
        studentMapper.updateStudentName(name, id);
    }

    //没有事务，执行一句提交一句
    public void withOutTranscation(){
        System.out.println("测试不开启事务");
        updateClassName("dddd", 1);
        if(1==1){
            throw new RuntimeException();
        }
        updateClassName("aaaaa", 1);
    }

    public void withTranscation(){
        System.out.println("测试开启事务");
        ((FooService)AopContext.currentProxy()).updateClassName("abcd", 1);

        if(1==1){
            throw new RuntimeException();
        }
        ((FooService)AopContext.currentProxy()).updateClassName("ggggg", 1);

    }

    @Transactional
    public void totalRun(){

        classService.updateClassName("更新className", 1);

        if(1==1){
            throw new RuntimeException();
        }

        studentService.updateStudentName("更新学生", 1);

    }


}
