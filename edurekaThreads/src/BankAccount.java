public class BankAccount {
    private double balance;
    private String accountNumber;


    public  BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        balance+= amount;
    }

    public synchronized void withdraw(double amount){
        balance -= amount;

    }

    public synchronized void getMyBalance(){
        System.out.println("Your balance is " + balance); ;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }

//    public void deposit(double amount){
//        synchronized (this){
//            balance+= amount;
//        }
//    }
//
//    public void withdraw(double amount){
//        synchronized (this){
//            balance -= amount;
//        }
//    }

}
