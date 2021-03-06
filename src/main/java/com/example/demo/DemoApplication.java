package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.example")
//允许获取本身代理对象
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	class Solution {
		public int numJewelsInStones(String J, String S) {
			for(String r: J.split("") ){
				S = S.replaceAll(r, "");
			}
			return S.length();

		}
	}
}
