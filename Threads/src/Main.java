public class Main {

    private static final String ANSI_BLUE = "\u001b[34m"; ;
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_RED = "\u001b[31m";


    public static void main(String[] args) {



        System.out.println(ANSI_CYAN + "Hello from main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another thread==");
        anotherThread.start();
        //anotherThread.run(); calls start method
        //start method internally calls run() method of runnable


        //creating anonymous class, to start a new thread

        new Thread(){
            public void run(){
                System.out.println(ANSI_PURPLE + "Hello from the annonymous class");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run(){
                System.out.println(ANSI_RED + "Hello from anonymous class implementation");
                //super.run();
                try{
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "another thread terminated, or timed out, running again");
                }catch(InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait, was interrupted");
                }
            }
        });

        myRunnableThread.start();
        //anotherThread.interrupt();

        System.out.println("Hello again from main thread");

        /** FAILS
         * AnotherThread.start();
         * The start method cannot be called once
         * on the same instance of a thread object
         * Note: You can't guarantee in which order a thread runs
         */
    }
}
