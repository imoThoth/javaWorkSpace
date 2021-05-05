import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /**
         * Notes
         * Two Threads, One produces messages
         *  One consumes messages
         */

        Message message = new Message();

        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message{
    private String message;
    private boolean empty = true;

    //Used by consumer to read message
    //empty is true when there is no message to read
    //read each message before writing next message
    //loop until there is a message to read
    //flag to true, then return message to caller/consumer
    public synchronized String read(){

        while(empty){
            try{
                wait();
            }catch (InterruptedException ex){

            }

        }
        empty = true;
        notifyAll();
        return message;
    }

    //Used by producer to write message
    //check to see if message is empty
    //else loop until message is empty
    //when leaving loop set empty to false
    //then write message
    public synchronized void write(String message){
        while(!empty){
            try{
                wait();
            }catch (InterruptedException ex){

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    public void run(){

        String messages[] = {
                "Winter nights are meant for coding",
                "When the air is cold, and the wind is thin",
                "And the only thing to keep your fingers warm",
                "Are the clitter, clatter of a keyboards strain"
        };

        Random random = new Random();

        for(int i=0; i< messages.length; i++){
            message.write(messages[i]);

            //creates a random delay
            try{
                Thread.sleep(random.nextInt(3500));
            }catch(InterruptedException ex){

            }
        }
        message.write("Finished");

    }
}

class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    public void run(){
        Random random = new Random();

        //Looop through messages received
        //Look for the last message "Finished"
        //process each message, print to console
        //wait randomly, exit when all message printed
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");
            latestMessage = message.read()){

            System.out.println(latestMessage);

            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException ex){

            }
        }
    }
}

/**
 * When a thread calls wait method, suspends execution, releases locks
 * Another thread issues notification
 * Always call wait within a loop
 * Never assume a thread has been woken up
 * */
