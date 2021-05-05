public class ThreadTwo extends Thread{
    public static final String ANSI_RED = "\u001b[31m";

    public void run(){
        System.out.println(ANSI_RED + "Hello from thread two");
        BankAccount account = new BankAccount("12345-675", 1000.00);
        account.deposit(203.75);
        account.withdraw(50.00);
        account.getMyBalance();
    }

}
