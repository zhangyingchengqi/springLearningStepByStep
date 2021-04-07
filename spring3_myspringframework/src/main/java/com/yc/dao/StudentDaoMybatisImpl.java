package com.yc.dao;

import java.util.Random;

/**
 * @program: TestSpring
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-04-04 14:48
 */
//@MyRepository
public class StudentDaoMybatisImpl implements StudentDao {
    @Override
    public int add(String name) {
        System.out.println("mybatis添加学生：" + name);
        Random r = new Random();
        return r.nextInt();
    }

    @Override
    public void update(String name) {
        System.out.println("mybatis更新学生：" + name);
    }
}
