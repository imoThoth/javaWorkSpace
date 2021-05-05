

public class MyRunnable implements Runnable {

    public static final String ANSI_RED = "\u001b[31m";

    @Override
    public void run(){
        System.out.println(ANSI_RED + "Hello from MyRunnable implementation of run");
    }
}
