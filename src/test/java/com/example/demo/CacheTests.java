package com.example.demo;

import com.example.demo.service.CacheService;
import com.example.demo.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTests {

	@Autowired
	FooService fooService;
	@Autowired
	CacheService cacheService;
	@Test
	public void testCache() throws Exception{

		System.out.println(cacheService.calStatics("tianhe", 1));
		System.out.println(cacheService.calStatics("tianhe", 1));
//		cacheService.evitCache();
		Thread.sleep(1000);
		System.out.println(cacheService.calStatics("tianhe", 1));
//		cacheService.evitCache()
		Thread.sleep(2000);	;
		System.out.println(cacheService.calStatics("tianhe", 1));
		System.out.println(cacheService.calStatics("tianhe", 1));
		System.out.println(cacheService.calStatics("tianhe", 1));
		System.out.println(cacheService.calStatics("tianhe", 1));
		Thread.sleep(2100);	;

		System.out.println(cacheService.calStatics("tianhe", 1));
		System.out.println(cacheService.calStatics("tianhe", 1));
	}


}
