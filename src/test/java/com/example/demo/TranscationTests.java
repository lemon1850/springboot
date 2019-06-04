package com.example.demo;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.ClassService;
import com.example.demo.service.FooService;
import com.example.demo.service.StudentService;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscationTests {

	@Before
	public void before(){

		studentMapper.updateStudentName("开始学生" , 1);
		classMapper.updateClassName("开始课", 1);
	}

	@Autowired
	FooService fooService;
	@Autowired
	StudentService studentService;
	@Autowired
	ClassService classService;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	ClassMapper classMapper;

	//没有事务，执行一句提交一句
	@Test
	public void withOutTranscation() {

		fooService.withOutTranscation();
	}
	@Test
	public void withTranscation() {

		fooService.withTranscation();
	}
	@Test
	public void updateClassName() {

		fooService.updateClassName("1212",1);
	}


	@Test
	public void totalRun(){

		fooService.totalRun();
	}


}
