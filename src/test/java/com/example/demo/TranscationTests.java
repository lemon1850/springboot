package com.example.demo;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscationTests {

	@Autowired
	FooService fooService;
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

}
