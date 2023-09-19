import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Balance{
    int balance = 0;
    AtomicInteger balanceUdt = new AtomicInteger(0);

    //increments the value at the time it was read, not the current value
    public void increment(){
        balance++;
    }

    public synchronized void incrementUdt(){
        balance++;
    }

    public void atomicIncrement(){
        balanceUdt.incrementAndGet();
    }
}


public class LostUpdateProblem {

    public static void main(String[] args) throws InterruptedException {

        // creates a thread pool to execute the jobs
        ExecutorService pool = Executors.newFixedThreadPool(6);
        int counter = 100;
        Balance balanceObj = new Balance();

        //run 15 attempts to update the balance
        for(int i = 0; i <= counter; i++){
            pool.execute(() -> balanceObj.atomicIncrement());
            System.out.println("Balance is " + balanceObj.balance);
        }
        pool.shutdown();

        if(pool.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("Balance after pool termnination = " + balanceObj.balance);
        }

    }
}
