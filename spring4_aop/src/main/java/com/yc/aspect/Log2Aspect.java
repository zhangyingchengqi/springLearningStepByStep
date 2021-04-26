package com.yc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect      //   切面类:   你要增强的功能写到这里
@Component   //IOC注解， 以实现让spring托管的功能
@Order(value = 10)
public class Log2Aspect {

    @Before("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    //@Before("execution(* com.yc.biz.StudentBizImpl.add*(..)) ||execution(* com.yc.biz.StudentBizImpl.update*(..)) ")
    public void log() {
        System.out.println("log2");
    }
}
