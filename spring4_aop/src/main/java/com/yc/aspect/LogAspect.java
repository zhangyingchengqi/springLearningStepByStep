package com.yc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Aspect      //   切面类:   你要增强的功能写到这里
@Component   //IOC注解， 以实现让spring托管的功能
@Order(value = 100)
public class LogAspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {  //DI
        System.out.println("=====compute====进到  增强了...");
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();  //目标类的目标方法
        long end = System.currentTimeMillis();
        System.out.println("compute1要退出增强了....");
        System.out.println("===========这个方法运行的时长为:" + (end - start));
        return retVal;
    }

    //切入点的声明    pointcut signature
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))") // 切入点表达式: 哪些方法上加增强
    private void add() {
    }

    @Pointcut("execution(*  com.yc.biz.StudentBizImpl.update*(..))") // 切入点表达式: 哪些方法上加增强
    private void update() {
    }

    @Pointcut("add() || update()")
    private void addAndUpdate() {
    }

    //@After("com.yc.aspect.LogAspect.addAndUpdate()")
    public void bye(JoinPoint jp) {    //spring是一个ioc容器，它可以使用di将程序 运行的信息注入    joinpoint.
        System.out.println("=========bye===========");
        //联接点中所有的信息
        Object target = jp.getTarget();
        System.out.println("目标类为:" + target);
        System.out.println("方法:" + jp.getSignature());
        Object[] objs = jp.getArgs();
        if (objs != null) {
            for (Object o : objs) {
                System.out.println("参数:" + o);
            }
        }
        System.out.println("=========bye===========");
    }


    //增加的声明
    @Before("add()")
    //@Before("execution(* com.yc.biz.StudentBizImpl.add*(..)) ||execution(* com.yc.biz.StudentBizImpl.update*(..)) ")
    public void log() {
        System.out.println("===============前置增强的日志=============");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr = sdf.format(d);
        System.out.println("执行时间为:" + dstr);
        System.out.println("===============前置增强的日志结束=============");
    }

    //切入点表达式的语法:  ?代表出现0次或一次
    // modifiers-pattern:修饰衔
    //ret-type-pattern:返回类型
    // declaring-type-pattern :
    //name-pattern: 名字模型
    // throws-pattern
    //  execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
    //                throws-pattern?)


}
