package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @program: TestSpring
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-04-04 14:49
 */
@Service//给spring的类托管
public class StudentBizImpl implements StudentBiz {
    @Autowired
    @Qualifier("studentDaoMybatisImpl")
    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentBizImpl() {
    }

    //@Autowired
    //@Qualifier("studentDaoJpaImpl")
    @Resource(name = "studentDaoMybatisImpl")
    //@Resource   //   如果没有找到同名的托管bean，  -> 则按类型查找bean,
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int add(String name) {
        System.out.println(" -------业务层------------");
        System.out.println("用户名是否重名");
        int result = studentDao.add(name);
        System.out.println("业务操作结束");
        return result;
    }

    @Override
    public void update(String name) {
        System.out.println("=====业务层=====");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("业务层结束");
    }

    @Override
    public void find(String name) {
        System.out.println("=====业务层=====");
        System.out.println("业务层查找用户名:" + name);
        studentDao.find(name);
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========业务层结束=====");
    }
}
