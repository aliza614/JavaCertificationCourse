import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    /*solution 3*/
    private Lock lock;
    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock=new ReentrantLock();
    }
    public /*synchronized IS 1 SOLUTION*/void deposit(double amount){
        /*THIS IS A SECOND SOLUTION synchronized (this) {
            balance += amount;
        }*/
        /*THIS IS THE THIRD SOLUTION*/
        lock.lock();
        try{
            balance+=amount;
        }finally{
            lock.unlock();
        }
    }
    public /*synchronized IS 1 SOLUTION*/void withdraw(double amount){
        /*THIS IS A SECOND SOLUTION synchronized (this){
            balance-=amount;
        }*/
        /*THIS IS THE THIRD SOLUTION*/
        lock.lock();
        try{
            balance-=amount;
        }finally {
            lock.unlock();
        }
    }

    public/*don't have to synchronize because it's not making changes*/ String getAccountNumber() {
        return accountNumber;
    }

    public/*don't have to synchronize because it's not making changes*/ void printAccountNumber(){
        System.out.println("Account number = "+accountNumber);
    }
}
