package com.example.demo.controller;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianhe on 2017/8/29.
 */
@Controller
public class TestRequestController {


    Class
    @RequestMapping("/abb")
    public String a(@RequestParam("cat") String name, @RequestParam Map<String,String> map ){
        System.out.println(name);
        System.out.println(map);
        return "abc";
    }


    @RequestMapping(value = "/bcc",)
    public String abc(@RequestBody Map<String,String> map ){
        System.out.println(map);
        return "abc";
    }


    @ResponseBody
    @GetMapping("/e")
    public Map Hello(){
        Map a = new HashMap();
        a.put("a","b");
        return a;
    }

    @RequestMapping("/f")
    public ResponseEntity<String> f(HttpEntity<byte[]> requestEntity){
        String requestHeader = requestEntity.getHeaders().getFirst("Accept");
//        String requestBody = requestEntity.getBody().toString();
        System.out.println(requestHeader);
        System.out.println(requestEntity);
        System.out.println(new String(requestEntity.getBody()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("AAAAAAAAAAAA", "BBBBBBBBBBB");
        return new ResponseEntity<String>("hello world", responseHeaders, HttpStatus.OK);

    }

}
