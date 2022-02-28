import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest2 {
    private BankAccount bankAccount;
    private static int count=0;
    @BeforeAll
    public static void beforeClass(){
//        int count=0;
        System.out.println("This executes before any test cases.  Count="+count);
    }

    @BeforeEach
    public void setup(){
        bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }
    @Test
    void deposit() {
        //fail("This test has yet to be implemented");
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance=bankAccount.deposit(200.00,true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, bankAccount.getBalance(),0);
    }

    @Test
    void withdraw_branch() {
        //fail("This test has yet to be implemented");
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance=bankAccount.withdraw(600.00,true);
        assertEquals(400.00, balance, 0);;
    }
    @Test //JUNIT4 way (expected =IllegalArgumentException.class)
    void withdraw_notBranch() {
        //fail("This test has yet to be implemented");
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        Exception exception=assertThrows(IllegalArgumentException.class,()-> {
            double balance=bankAccount.withdraw(600.00,false);
        });
        assertTrue(exception.getClass().equals(IllegalArgumentException.class));

    }

    @Test
    void getBalance_deposit() {
        //fail("This test has yet to be implemented");
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance=bankAccount.deposit(200.00,true);
        assertEquals(1200.00, bankAccount.getBalance(),0);
    }

    @Test
    void getBalance_withdraw() {
        //fail("This test has yet to be implemented");
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance=bankAccount.withdraw(200.00,true);
        assertEquals(800.00, bankAccount.getBalance(),0);
    }

    @Test
    void isChecking_true(){
//        BankAccount bankAccount=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        assertTrue(bankAccount.isChecking(), "the account is not a checking account");
    }
    @AfterAll
    public static void afterClass(){
        System.out.println("This executes after any tests.  Count="+ count++);
    }

    @AfterEach
    public void teardown(){
        System.out.println("Count= "+ count++);
    }

}