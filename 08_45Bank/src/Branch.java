import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;
/*2.  Branch

    -  It has two fields, A String called name and an ArrayList that holds objects of type Customer called customers.

                -  A constructor that takes a String (name of the branch). It initialises name and instantiates customers.
*/
public Branch(String name) {
    this.name = name;
    this.customers=new ArrayList<Customer>();
}
//                -  And five methods, they are (their functions are in their names):

//                    -  getName(), getter for name.
public String getName() {
    return name;
}

//        -  getCustomers(), getter for customers.
public ArrayList<Customer> getCustomers() {
    return customers;
}

//        -  newCustomer(), has two parameters of type String (name of customer), double (initial transaction) and returns a boolean. Returns true if the customer was added successfully or false otherwise.
public boolean newCustomer(String customerName,double initialTransaction) {
    if (findCustomer(customerName) == null) {
        customers.add(new Customer(customerName, initialTransaction));
        return true;
    } else return false;
}
//        -  addCustomerTransaction(), has two parameters of type String (name of customer), double (transaction) and returns a boolean. Returns true if the customers transaction was added successfully or false otherwise.
public boolean addCustomerTransaction(String customerName, double transaction){
    if(findCustomer(customerName)!=null) {
        Customer customer = findCustomer(customerName);
        customer.addTransaction(transaction);
        return true;
    }
    return false;
}
//        -  findCustomer(), has one parameter of type String (name of customer) and returns a Customer. Return the Customer if they exist, null otherwise.

public Customer findCustomer(String customerName){
    for (int i = 0; i < customers.size(); i++) {
        Customer customer=customers.get(i);
        if (customer.getName().equals(customerName))
            return customer;
    }
    return null;
}



}
