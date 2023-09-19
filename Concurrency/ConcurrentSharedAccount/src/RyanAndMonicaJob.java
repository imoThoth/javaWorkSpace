public class RyanAndMonicaJob implements Runnable {

    AtomicBankAccount atomicBankAccount;
    BankAccount account;
    private String name;
    private int amountToSpend;

    public RyanAndMonicaJob(String name, int amountToSpend, BankAccount account){
        this.name = name;
        this.amountToSpend = amountToSpend;
        this.account = account;
    }

    public RyanAndMonicaJob(String name, int amountToSpend, AtomicBankAccount atomicBankAccount){
        this.name = name;
        this.amountToSpend = amountToSpend;
        this.atomicBankAccount = atomicBankAccount;
    }


    @Override
    public void run() {
//        goShopping(amountToSpend);
//        goShoppingSync(amountToSpend);
//        goShoppingMethodSyc(amountToSpend);
        goShoppingAdvanced(amountToSpend);
    }

    //P4
    private void goShoppingAdvanced(int amount){
        System.out.println(name + " is about to spend");
        account.spendUpdate(name, amount);
        System.out.println(name + " finished Spending " + amount);
    }

    // when using threads, creating a method likes this
    // allows multiple threads to access the method at the same time
    // this can lead to the account being over drawn
    // P1
    private void goShopping(int amount){
        if(account.getBalance() >= amount){
            System.out.println(name + " has spent " + amount);
            account.spend(amount);
            System.out.println(name + " has finished spending, Balance: " + account.getBalance());
        }else{
            System.out.println("This broke motherfukcer called " + name);
        }
    }

    // using a synchronized block
    // creates a key, meaning only one thread can access method
    // this method works by creating a lock for an object
    // only one thread can access this object at any one time
    // P2
    private void goShoppingSync(int amount){
        synchronized (account){
            if(account.getBalance() >= amount){
                System.out.println(name + " has spent " + amount);
                account.spend(amount);
                System.out.println(name + " has finished spending, Balance: " + account.getBalance());
            }else{
                System.out.println("This broke motherfukcer called " + name + " aint got no money to spend");
            }
        }
    }

    // this works by creating a lock for a method
    // note -: object can create separate instance of the same class
    // meaning an object placing a lock in its own instance, won't effect another objects instance
    // P3
    private synchronized void goShoppingMethodSyc(int amount){
        if(account.getBalance() >= amount){
            System.out.println(name + " has spent " + amount);
            account.spend(amount);
            System.out.println(name + " has finished spending, Balance: " + account.getBalance());
        }else{
            System.out.println("This broke motherfukcer called " + name + " aint got no money to spend");
        }
    }
}
