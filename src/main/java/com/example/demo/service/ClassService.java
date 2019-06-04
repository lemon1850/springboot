package com.example.demo.service;


import com.example.demo.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClassService {

    @Resource
    ClassMapper classMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void updateClassName(String name, int id){
        classMapper.updateClassName(name, id);
    }



}
