package com.yc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect      //   切面类:   你要增强的功能写到这里
@Component
@Order(value = 1)
public class Log3Aspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute2(ProceedingJoinPoint pjp) throws Throwable {  //DI
        System.out.println("*******************compute2进到  增强了...");
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();  //目标类的目标方法
        long end = System.currentTimeMillis();
        System.out.println("compute2要退出增强了....");
        System.out.println("**********这个方法运行的时长为:" + (end - start));
        return retVal;
    }
}
