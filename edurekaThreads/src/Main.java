public class Main {
    public static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_CYAN = "\u001b[36m";


    public static void main(String[] args) {
        //create and start two threads using joint account at same time.
        //two thread using same bank account instance with balance of 1000
        //thread one will deposit 300 into the account and then withdraw 50
        //thread two will deposit 203.75 and then withdraw 100

        ThreadOne firstThread = new ThreadOne();
        ThreadTwo secondThread = new ThreadTwo();

       // secondThread.start();
        //firstThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_PURPLE+"Hello from first account");
                BankAccount secondAccount = new BankAccount("2348-8762", 1000.00);
                secondAccount.deposit(300);
                secondAccount.withdraw(50);
                secondAccount.getMyBalance();
            }
        }.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_CYAN+"Hello from second account");
                BankAccount secondAccount = new BankAccount("2348-8762", 1000.00);
                secondAccount.deposit(203.75);
                secondAccount.withdraw(100);
                secondAccount.getMyBalance();
            }
        }.start();

//        Thread trThread1 = new Thread(){
//            public void run(){
//                BankAccount rtThread = new BankAccount("2348-8762", 1000.00);
//                rtThread.deposit(300);
//                rtThread.withdraw(50);
//                rtThread.myBalance();
//            }
//        };

    }
}




