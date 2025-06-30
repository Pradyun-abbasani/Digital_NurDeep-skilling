package com.demo;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(100);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.withdraw(200);
    }
}
