import java.text.MessageFormat;

public class Main {

    static void greetApprentice(String[] apprentices){
        for(String apprentice: apprentices ){
            greet(apprentice);
        }
    }

    private static void greet(String apprentice){
        System.out.println("Hello, nice to meet you " + apprentice);
    }

    public static void main(String[] args){
        greetApprentice(new String[]{"Hoda", "Luke" ,"Yoda"});
    }
}