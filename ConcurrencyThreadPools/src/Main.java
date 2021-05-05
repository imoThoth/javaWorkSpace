import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.parser.TokenType.EOF;

/**
 * Thread pool = managed set of thread
 * reduces overhead of thread creation
 * works well with apps using large amount of threads
 * Thread pools are used through executive services or through thread interfaces
 *
 * Replaced by the execute method, in executive-service
 * (new Thread(r)).start();
 *           ex.execute(r);
 * */

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String>buffer = new ArrayList<String>();

        //if thread is holding the lock, when it reaches code holding same lock
        //continue execution
        ReentrantLock bufferLock = new ReentrantLock();

        //Creates three fixed threads, 1 for producer, 2 for consumers
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer,ThreadColour.ANSI_YELLOW, bufferLock);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColour.ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_GREEN, bufferLock);

        //executes allocation of threads
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer1);

        /** Notes
         * submit is used to receive value back from thread being executed in background
         * similar to runnable, uses callable object excepts it except it return value
         * the value returned, is an object of type future
         * */
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColour.ANSI_GREEN + "Im being printed from callable class");
                return "This is the callable result";
            }
        });


        //calls to future.get are blocked until the return type is available
        //when called from main method, it is frozen until the results are available
        try{
            System.out.println(future.get());
        }catch(ExecutionException ex){
            System.out.println("future failed to execute");
        }catch (InterruptedException ex){
            System.out.println("future was interrupted");
        }

        //shuts down executor service
        // ensures client cannot send more tasks
        executorService.shutdown();
    }
}

//Constructor accepts buffer shared by consumer
//accepts color printed to console
//run method writes 1-6 to buffer as string
//before writing to buffer print color
//after writing buffer go to sleep on random interval
//adds EOF to show End of file
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock){
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1","2","3","4","5","6"};

        for(String num : nums){
            try{
                System.out.println(color + "Adding.." + num);
                bufferLock.lock();

                try{
                    buffer.add(num);
                }finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));

            }catch(InterruptedException ex){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();

        try{
            buffer.add("EOF");
        }finally{
            bufferLock.unlock();
        }

    }
}
//Accepts buffer shared from producer and color
//Loops until reads EOF
//inside loop check if there is something to read
//keep checking until buffer isnt empty
//look at first element in buffer to see if EOF
//prints exiting to console, then break out
//if EOF is removed, infinite loop
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;


    public MyConsumer(List<String>buffer, String color, ReentrantLock bufferLock){
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    //Ensures producer or consumer does not alter array list
    // when array list has been checked
    //all calls execute has a unit
    //counter checks how many times a thread tries to enter without a key
    public void run(){
        int counter = 0;

        while(true){
            if(bufferLock.tryLock()){
                try{
                    if(buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color + "This counter =" + counter) ;
                    counter = 0;

                    if(buffer.get(0).equals("EOF")){
                        System.out.println(color + "Exiting");
                        break;
                    }else{
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }

            } else{
                counter++;
            }

        }

    }
}
