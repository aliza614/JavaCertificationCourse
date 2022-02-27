import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest2 {

    @Test
    void deposit() {
        //fail("This test has yet to be implemented");
        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance=bankAccount.deposit(200.00,true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, bankAccount.getBalance(),0);
    }

    @Test
    void withdraw() {
        //fail("This test has yet to be implemented");
        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance=bankAccount.withdraw(200.00,true);
        assertEquals(800.00, balance, 0);;
    }

    @Test
    void getBalance_deposit() {
        //fail("This test has yet to be implemented");
        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance=bankAccount.deposit(200.00,true);
        assertEquals(1200.00, bankAccount.getBalance(),0);
    }

    @Test
    void getBalance_withdraw() {
        //fail("This test has yet to be implemented");
        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance=bankAccount.withdraw(200.00,true);
        assertEquals(800.00, bankAccount.getBalance(),0);
    }

}