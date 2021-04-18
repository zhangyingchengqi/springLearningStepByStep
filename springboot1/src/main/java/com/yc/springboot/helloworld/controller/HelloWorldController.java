package com.yc.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController    //   @Controller控制层   @Restful 以rest规范(  请求方式:get,post,put,delete,     json)发请求和响应
public class HelloWorldController {

    @GetMapping("/hello")   // 请求方式为  get   ,请求路径为:  /hello
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {   // @RequestParam请求的参数name
        return String.format("Hello %s!", name);
    }
}
