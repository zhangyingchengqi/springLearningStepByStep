package com.example.demo;

import com.yc.tx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(basePackages = "com.yc.tx")
public class DemoApplication {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    String home() {
        System.out.println(accountService);
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
