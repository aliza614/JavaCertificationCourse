public class Challenge1Main {
    public static void main(String[] args) {
        //starting balance of 1000.
        final BankAccount account=new BankAccount("12345-678", 1000.00);
        //2 threads
// THIS IS ONE SOLUTION
//        //1 deposits 300.00 and then withdraws 50
//        Thread thread1 =new Thread (){
//            @Override
//            public void run() {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//        //2 deposits 203.75 and then withdraws 100
//        Thread thread2=new Thread(){
//            @Override
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100.00);
//            }
//        };

//        THIS IS NOW THE SECOND SOLUTION
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        });
//        THIS IS PART OF BOTH SOLUTIONS
                thread1.start();
        thread2.start();
    }

}
