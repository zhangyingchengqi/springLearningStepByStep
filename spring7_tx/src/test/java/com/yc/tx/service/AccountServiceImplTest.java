package com.yc.tx.service;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpTypes;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceImplTest extends TestCase {
    @Autowired
    private AccountService accountService;

    @Test
    public void testOpenAccount() {
        Integer accountid = accountService.openAccount(new Accounts(), 1);
        System.out.println(accountid);
        Assert.assertNotNull(accountid);
    }

    @Test
    public void testDeposite() {
        Accounts a = new Accounts();
        a.setAccountId(6);
        Accounts aa = accountService.deposite(a, 100, OpTypes.deposite.getName(), null);
        System.out.println(aa);
    }

    @Test
    public void testWithdraw() {
        Accounts a = new Accounts();
        a.setAccountId(6);
        Accounts aa = accountService.withdraw(a, 999, OpTypes.withdraw.getName(), null);
        System.out.println(aa);
    }

    @Test
    public void testTransfer() {
        Accounts out = new Accounts();
        out.setAccountId(6);

        Accounts inA = new Accounts();
        inA.setAccountId(7);

        this.accountService.transfer(inA, out, 5);
    }

    @Test
    public void testShowBalance() {
        Accounts a = new Accounts();
        a.setAccountId(6);
        a = this.accountService.showBalance(a);
        System.out.println(a);
    }

    @Test
    public void testFindById() {
    }
}