package com.yc.springboot.helloworld.controller;

import com.yc.springboot.helloworld.properties.YcProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController    //   @Controller控制层   @Restful 以rest规范(  请求方式:get,post,put,delete,     json)发请求和响应
public class HelloWorldController {
    //创建日志对象                                 必须写当前类的反射类
    private static Log log = LogFactory.getLog(HelloWorldController.class);

    //StandardServletEnvironment {activeProfiles=[],
    // defaultProfiles=[default],
    // propertySources=[MapPropertySource {name='server.ports'},
    // ConfigurationPropertySourcesPropertySource {name='configurationProperties'},
    // StubPropertySource {name='servletConfigInitParams'},
    // ServletContextPropertySource {name='servletContextInitParams'},
    // PropertiesPropertySource {name='systemProperties'},
    // OriginAwareSystemEnvironmentPropertySource {name='systemEnvironment'},
    // RandomValuePropertySource {name='random'},
    // OriginTrackedMapPropertySource {name='Config resource 'class path resource [application.yml]' via location 'optional:classpath:/''},
    // MapPropertySource {name='devtools'}]}
    @Autowired
    private Environment env;

    @Value("${yc.tname}")
    private String tname;

    @Autowired
    private YcProperties yp;


    @GetMapping("/hello")   // 请求方式为  get   ,请求路径为:  /hello
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.debug("*****debug****");
        log.info("******info*****");
        log.error("*****error********");
        log.fatal("*****fatal********");

        log.info("系统环境变量信息如下:" + env);
        log.info("用户路径:" + env.getProperty("user.home"));

        log.info("" + env.getProperty("JAVA_HOME"));

        log.info("yc.tname:" + tname);

        log.info("YcProperties中的属性:" + yp.getTname() + "\t" + yp.getAge());
        log.info("env中是否也可以拿到呢?" + env.getProperty("yc.tname") + "\t" + env.getProperty("yc.age"));


        // @RequestParam请求的参数name
        return String.format("Hello %s!", name);


    }


    @GetMapping("/hello2")   // 请求方式为  get   ,请求路径为:  /hello
    public String hello2() {   // @RequestParam请求的参数name
        return "你好，异界";
    }

    @GetMapping("/hello3")   // 请求方式为  get   ,请求路径为:  /hello
    public String hello3() {   // @RequestParam请求的参数name
        return "你好，异界";
    }
}
