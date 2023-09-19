import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSharedAccount {

    public static void main(String[] args){

        BankAccount account = new BankAccount();
        AtomicBankAccount atomicBankAccount = new AtomicBankAccount();


        RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", 80, account);
        RyanAndMonicaJob joey = new RyanAndMonicaJob("Joey", 70, account);
        RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", 70, account);
        RyanAndMonicaJob rachel = new RyanAndMonicaJob("Rachel", 80, account);

        System.out.println("The account begins with: " + account.getBalance());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(joey);
        executorService.execute(rachel);
        executorService.shutdown();
    }
}