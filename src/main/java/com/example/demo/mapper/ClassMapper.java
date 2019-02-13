package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassMapper {

    public int updateClassName(@Param("name") String className, @Param("id") int id);
}
