package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@CrossOrigin
@RestController
@CrossOrigin
public class HelloController {
    @RequestMapping(value = "/")
    public String index(){
        return "welcome to use 接口系统";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public Object hello(String id){
        Map map = new HashMap();
        map.put("id",id);
        map.put("username","yangliping");
        map.put("email","iqlife@163.com");
        map.put("address","杭州");
        map.put("tel","17090886636");
        return  map;
    }
}
