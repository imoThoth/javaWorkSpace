public class BankAccount {

    private int balance = 100;

    public BankAccount() { }

    public int getBalance() {
        return balance;
    }

    public void spend(int amount){
        this.balance = this.balance - amount;
        if(balance < 0){
            System.out.println("Account overdrawn");
        }
    }

//    P5
    public synchronized void spendUpdate(String name, int amount){
        if(balance >= amount){
            balance = this.balance - amount;
            if(balance < 0){
                System.out.println(name + " has overdrawn the account");
            }
        }else{
            System.out.println("Sorry " + name + " insufficient funds in account");
        }
    }
}
