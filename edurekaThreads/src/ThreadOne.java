public class ThreadOne extends Thread {

   public static final String ANSI_BLUE = "\u001b[34m";

    public void run(){
        System.out.println(ANSI_BLUE + "Hello from thread one");
        BankAccount account = new BankAccount("12345-675", 1000.00);
        account.deposit(300.00);
        account.withdraw(50.00);
        account.getMyBalance();
    }
}
