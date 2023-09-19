import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBankAccount {

    // stores balance as an atomic integer
    private final AtomicInteger balance = new AtomicInteger(100);

    public int getBalance(){
        return balance.get();
    }

    public void spend(String name, int amount){

        int initialBalance = balance.get();
        if(initialBalance >= amount){
            boolean success = this.balance.compareAndSet(initialBalance, initialBalance - amount);
            if(success){
                System.out.println(name + " You have successfully withdrawn " + amount);
            }
        }else{
            System.out.println("Unable to process transaction for " + name);
        }

    }
}
