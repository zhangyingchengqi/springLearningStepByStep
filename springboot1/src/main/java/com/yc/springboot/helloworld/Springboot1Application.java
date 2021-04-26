package com.yc.springboot.helloworld;

import com.yc.springboot.helloworld.properties.YcProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(YcProperties.class)
public class Springboot1Application extends SpringBootServletInitializer {
    private static Log log = LogFactory.getLog(Springboot1Application.class);


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        log.info("程序 启动了");
        return application.sources(Springboot1Application.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }


}
