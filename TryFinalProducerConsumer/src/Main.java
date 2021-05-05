import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.parser.TokenType.EOF;

/**Note
 *
 *Thread add data to a buffer to producers
 *Thread consuming data from a buffer conumsers
 * */

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String>buffer = new ArrayList<String>();
        //if thread is hold reentract lock, when it reaches code holding same lock
        //continue execution
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducer producer = new MyProducer(buffer,ThreadColour.ANSI_YELLOW, bufferLock);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColour.ANSI_BLUE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_GREEN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer1).start();
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
    ReentrantLock bufferLock = new ReentrantLock();

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

                Thread.sleep(random.nextInt(2000));

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
    ReentrantLock bufferLock = new ReentrantLock();


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

                if(buffer.get(0).equals(EOF)){
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