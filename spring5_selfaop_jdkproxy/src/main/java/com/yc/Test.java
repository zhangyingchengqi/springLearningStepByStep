package com.yc;

import com.yc.biz.StudentBiz;
import com.yc.biz.StudentBizImpl;

public class Test {
    public static void main(String[] args) {
        StudentBiz target = new StudentBizImpl();   //spring 进行ioc

        LogAspect la = new LogAspect(target);

        Object obj = la.createProxy();  // obj就是代理对象
        //System.out.println(obj.toString());

        if (obj instanceof StudentBiz) {
            StudentBiz sb = (StudentBiz) obj;

            int a = sb.add("李四 ");
            System.out.println(a);

        }

    }
}
