import java.util.concurrent.TimeUnit;
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
        /*THIS IS THE THIRD SOLUTION*
        lock.lock();
        try{
            balance+=amount;
        }finally{
            lock.unlock();
        }
        */
        /*THIS IS THE FOURTH SOLUTION*/
        boolean status=false;
         try{
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance+=amount;
                    status=true;
                }
                finally{
                    lock.unlock();
                }
            }else{
                System.out.println("Could not get the lock");
            }
         } catch (InterruptedException e){

         }
        System.out.println("Transaction status= "+status);
    }
    public /*synchronized IS 1 SOLUTION*/void withdraw(double amount){
        /*THIS IS A SECOND SOLUTION synchronized (this){
            balance-=amount;
        }*/
        /*THIS IS THE THIRD SOLUTION*
        lock.lock();
        try{
            balance-=amount;
        }finally {
            lock.unlock();
        }

         */
        /*THIS IS THE FOURTH SOLUTION*/
        boolean status=false;
        try{
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                try{
                    balance-=amount;
                    status=true;
                }finally{
                    lock.unlock();
                }
            }else{
                System.out.println("Could not get the lock");
            }
        }catch (InterruptedException e){

        }
        System.out.println("Transaction status= "+status);
    }

    public/*don't have to synchronize because it's not making changes*/ String getAccountNumber() {
        return accountNumber;
    }

    public/*don't have to synchronize because it's not making changes*/ void printAccountNumber(){
        System.out.println("Account number = "+accountNumber);
    }
}
