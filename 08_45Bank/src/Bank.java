import java.util.ArrayList;

public class Bank {
    /*
    Your job is to create a simple banking application.

    Implement the following classes:

            1.  Bank
*/
//-  It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
    private String name;
    private ArrayList<Branch> branches;

//            -  A constructor that takes a String (name of the bank). It initialises name and instantiates branches.

    public Bank(String name) {
        this.name = name;
        this.branches=new ArrayList<Branch>();
    }
    //-  And five methods, they are (their functions are in their names):

//                -  addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the branch was added successfully or false otherwise.
    public boolean addBranch(String branchName){
        //if found branch
        if (findBranch(branchName)!=null){
            return false;
        }else{
            this.branches.add(new Branch(branchName));
            return true;
        }

    }
//    -  addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch=findBranch(branchName);
        if (branch!=null){
            return branch.newCustomer(customerName,initialTransaction);
        }
        else
            return false;
}
//    -  addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added successfully or false otherwise.
public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch=findBranch(branchName);
        if (branch!=null){

            return branch.addCustomerTransaction(customerName,transaction);
        }
        return false;
    }
//    -  findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if it exists or null otherwise.
private Branch findBranch(String branchName){
        for (int i=0;i< branches.size();i++)
        {
            Branch branch=branches.get(i);
            if(branch.getName().equals(branchName))
                return branch;
        }
        return null;
}
//    -  listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch=findBranch(branchName);
        if (branch!=null){
            System.out.println("Customer details for branch "+branchName);
            ArrayList<Customer> branchCustomers=branch.getCustomers();
            for (int i=0;i<branchCustomers.size();i++){
                Customer branchCustomer=branchCustomers.get(i);
                System.out.println("Customer: "+branchCustomer.getName()+"["+(i+1)+"]");
                if(printTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions=branchCustomer.getTransactions();
                    for (int j=0;j<transactions.size();j++){
                        Double transaction=transactions.get(j);
                        System.out.println("["+(j+1)+"] Amount "+transaction);
                    }
                    return true;

                }
                else return false;
            }
        }
        return false;
}
  /*          → TEST CODE

    Bank bank = new Bank("National Australia Bank");

bank.addBranch("Adelaide");

bank.addCustomer("Adelaide", "Tim", 50.05);
bank.addCustomer("Adelaide", "Mike", 175.34);
bank.addCustomer("Adelaide", "Percy", 220.12);

bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

bank.listCustomers("Adelaide", true);

→ OUTPUT

    The list of customers should be printed out in the following format if boolean parameter is true:

    Customer details for branch Adelaide
    Customer: Tim[1]
    Transactions
[1]  Amount 50.05
            [2]  Amount 44.22
            [3]  Amount 12.44
    Customer: Mike[2]
    Transactions
[1]  Amount 175.34
            [2]  Amount 1.65
    Customer: Percy[3]
    Transactions
[1]  Amount 220.12

    and if false, only the customers - no transactions:

            bank.listCustomers("Adelaide", false);

    Customer details for branch Adelaide
    Customer: Tim[1]
    Customer: Mike[2]
    Customer: Percy[3]


    TIP:  In Bank, use the findBranch() method in each of the other four methods to validate a branch. Do the same thing in Branch with findCustomer() - except for the two getters.

            TIP:  In Customer, think about what else you need to do in the constructor when you instantiate a Customer object.

            TIP:  Think about what methods you need to call from another class when implementing a method.

    TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.

    TIP:  Be extremely careful about spaces and spelling in the printed output.

            NOTE:  All transactions are deposits (no withdraws/balances).

    NOTE:  All fields are private.

    NOTE:  All constructors are public.

    NOTE:  All methods are public (except for findBranch() and findCustomer() which are private).

    NOTE:  There are no static members.

            NOTE:  Do not add a main method to the solution code.

    NOTE:  If you get an error from the Evaluate class, it's most likely the constructor. Check if you've added a constructor or if the constructor has the right arguments.
*/}
