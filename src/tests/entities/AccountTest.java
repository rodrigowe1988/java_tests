package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import factory.AccountFactory;

class AccountTest {

    @Test
    void depositShouldIncreaseBalanceWhenPositiveAmount() {

        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();
        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }
    
    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {
    	
    	double expectedValue = 100.0;
    	Account acc = AccountFactory.createAccount(expectedValue);
    	double amount = -200.0;
    	
    	acc.deposit(amount);
    	
    	Assertions.assertEquals(expectedValue, acc.getBalance() );
    }
    
    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
    	
    	double expectedValue = 0.0;
    	double initialBalance = 500.0;
    	Account acc = AccountFactory.createAccount(initialBalance);
    	
    	double result = acc.fullWithdraw();
    	
    	Assertions.assertTrue(expectedValue == acc.getBalance());
    	Assertions.assertTrue(result == initialBalance);

    }

}