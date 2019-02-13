package com.example.demo.service;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CacheService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassMapper classMapper;



    @Cacheable(cacheNames = "cal")
    public String calStatics(String className, int id ){
        System.out.println("计算很复杂的运算");
        System.out.println(new Date());
        try{
            Thread.sleep(3000);
            System.out.println(new Date());

        }catch (InterruptedException e){
            throw new RuntimeException();
        }


        return "测试缓存";
    }

    @CacheEvict(cacheNames = "cal", allEntries = true)
    public void evitCache( ){

    }


}
