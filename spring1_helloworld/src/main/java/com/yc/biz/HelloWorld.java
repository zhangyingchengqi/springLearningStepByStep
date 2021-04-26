package com.yc.biz;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

//只要加了这个注解，则这个类可以被spring容器托管
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Component
public class HelloWorld {   // 创建这个类的对象???

    public HelloWorld() {
        System.out.println("无参构造方法");
    }

    public void hello() {
        System.out.println("hello world");
    }
}
