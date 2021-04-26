package com.yc.dao;


import com.yc.tx.AppConfig;
import com.yc.tx.bean.Accounts;
import com.yc.tx.dao.AccountsDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountsDao accountsDao;

    @Test   //数据源测试.
    public void testDataSource() {
        Assert.assertNotNull(dataSource);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void testAccountsDaoImpl() {
        Assert.assertNotNull(accountsDao);
    }

    @Test
    public void testOpenAccounts() {
        Accounts a = new Accounts();
        a.setBalance(10.0);
        int accountid = accountsDao.saveAccount(a);
        System.out.println("开户成功，新开户头id为:" + accountid);
    }

    @Test
    public void testFindAll() {
        List<Accounts> list = this.accountsDao.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindByid() {
        Accounts a = this.accountsDao.findAccount(4);
        System.out.println(a);
    }
}
