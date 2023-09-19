import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class Chat{

    private final String message;
    private final LocalDateTime timeStamp;

    public Chat(String message){
        this.message = message;
        timeStamp = LocalDateTime.now();
    }

    public String toString(){
        String time = timeStamp.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        return time + " " + message;
    }
}

public class CollectionsAndConcurreny {
    public static void main(String[] args) {
        // chat obj stored in array list which is not thread safe
        ArrayList<Chat> chatHistory = new ArrayList<>();
        CopyOnWriteArrayList<Chat> chatHistoryThreadSafe = new CopyOnWriteArrayList<Chat>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //creates 1 thread which writes to the list
        //and 2 threads which read from the list
        //this may lead to a concurrent modfication exception
        //where one thread is writing and another thread is reading at the same time
        for(int i = 0; i < 5; i++){
            executorService.execute(() -> chatHistoryThreadSafe.add(new Chat("Hello Server")));
            executorService.execute(() -> System.out.println(chatHistoryThreadSafe));
            executorService.execute(() -> System.out.println(chatHistoryThreadSafe));
        }

        executorService.shutdown();
    }
}


























