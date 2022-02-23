public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public /*synchronized IS 1 SOLUTION*/void deposit(double amount){
        /*THIS IS A SECOND SOLUTION*/synchronized (this) {
            balance += amount;
        }
    }
    public /*synchronized IS 1 SOLUTION*/void withdraw(double amount){
        /*THIS IS A SECOND SOLUTION*/synchronized (this){
            balance-=amount;
        }
    }
}
