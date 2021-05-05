import java.text.MessageFormat;

//first create a greet method, takes string apprentice name
//greet method returns message nice to meet you
//
public class Main {

    private static void greetApprentice(String[] apprentices){
        for(String apprentice: apprentices ){
            greet(apprentice);
        }
    }

    private static void greet(String apprentice){
        System.out.println(MessageFormat.format("Hello, {0}, nice to meet you.", apprentice));
    }

    public static void Main(String[] args){
        greetApprentice(new String[]{"Hoda", "Luke" ,"Yoda"});
    }
}
