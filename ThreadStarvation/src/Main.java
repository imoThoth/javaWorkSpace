/**
 * Starvation is when threads do not have the opportunity to run/progress
 * Caused by thread priority
 *
 * */


public class Main {
    //used to synchronize code
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColour.ANSI_BLUE), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColour.ANSI_RED), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColour.ANSI_YELLOW), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColour.ANSI_PURPLE), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColour.ANSI_WHITE), "Priority 2");

        t1.setPriority(10);
        t1.setPriority(8);
        t1.setPriority(6);
        t1.setPriority(4);
        t1.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColour;

        public Worker(String threadColour){
            this.threadColour = threadColour;
        }
        @Override
        public void run(){
            for(int i =0; i< 100; i++){
                synchronized (lock){
                    System.out.format(threadColour + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    //execute critical section of code
                }
            }
        }
    }
}
