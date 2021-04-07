package com.yc.biz;

import com.yc.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(classes = {AppConfig.class}) //加载配置文件

@DependsOn("helloWorld")
public class HelloWorldTest2 {   //测试用例
    @Autowired
    private HelloWorld hw;  //默认情况下，所有的bean都是  eager

    @Autowired
    private HelloWorld hw2;

    @Test
    public void testHello() {
        System.out.println("aaa");

        System.out.println(hw.hashCode() + "\t" + hw2.hashCode());
    }
}