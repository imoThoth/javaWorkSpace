public class Main {

    public static void main(String[] args) {

        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName(("Thread 2"));

        t1.start();
        t2.start();
    }

}

class Countdown{

    private int i;

    //synchronized keyword, tells jvm
    //run the method with a single thread
    //before letting another thread join the party
    //public synchronized void doCountdown(){
    public void doCountdown(){
        String color;

        switch(Thread.currentThread().getName()){

            case "Thread 1":
                color = ThreadColour.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColour.ANSI_PURPLE;
                break;
            default:
                color =ThreadColour.ANSI_GREEN;
        }
        //uses this.countdown to synchronize methods
        //synchronized (this){
            for (i=10; i > 0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
            }
       // }
    }
}

//Allows us to start the thread
//When instance of class started, calls doCountdown method
class CountdownThread extends Thread{

    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }

    public void run(){
        threadCountdown.doCountdown();
    }
}

/** Notes
 *  Block of statement may be sycnhronized
 * Every java object as an intrinsic lock aka monitor
 * You can synchronize a block of statement, working with object
 * by forcing thread to acquire object lock before executing task
 *  only one thread may acquire a lock at all times
 *
 *  Try not to use local variables to synchronize
 * */
