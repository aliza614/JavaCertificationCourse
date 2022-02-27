public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;


    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    //The branch arguement is true if a customer is performing the transaction
    // at a branch with a teller.
    //it's false if the customer is performing the transaction at an ATM
    public double deposit(double amount, boolean branch){
        balance +=amount;
        return balance;
    }

    //The branch arguement is true if a customer is performing the transaction
    // at a branch with a teller.
    //it's false if the customer is performing the transaction at an ATM

    public double withdraw(double amount, boolean branch){
        balance-=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
    //more methods that use first name and last name and perform other functions
}
