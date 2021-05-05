import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class A{
    public void print(){
        System.out.println("A");
    }
}

class B extends A{
    public void print(){
        System.out.println("B");
    }
}

public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("\n---Comparing Strings---\n");
        String s1 = "OCAJP";
        String s2 = "OCAJP" + "";
        System.out.println(s1.equals(s2));

        System.out.println("\n---CATCH---\n");
        /*
        try{
            main(args);
        } catch (Exception ex){
            System.out.println("Catch-");
        }
        System.out.println("OUT"); //Infinity loop of println CATCH
        */

        System.out.println("\n---Switch---\n");
        String fruit = "Mango";
        switch (fruit){
            default:
                System.out.println("Any fruit will do");
                break;
            case "Apple":
                System.out.println("Apple");
                break;
            case "Mango":
                System.out.println("Mango");
                break;
            case"Banana":
                System.out.println("Banana");
                break;
        }

        System.out.println("\n---Using List and Predicate---\n");
        /*
        List<String> dryFruits = new ArrayList<>();
        dryFruits.add("Walnuts");
        dryFruits.add("Almonds");
        dryFruits.add("Apricots");
        dryFruits.add("Dates");

        Iterator<String> iterator = dryFruits.iterator();
        while(iterator.hasNext()){
            String dryFruit = iterator.next();
            if(dryFruit.startsWith("A")){
                dryFruits.remove(dryFruit); // my guess Removes Almond and Apricots
            }
            System.out.println(dryFruits);//Prints out arraylist and concurrent errors
        }
        */



        System.out.println("\n---Printing Arrays----\n");
        int [] arr = {2, 1, 0};
        for(int i: arr){
            System.out.println(arr[i]); //prints 0, 1, 2
        }//my answer 2,1,0

        System.out.println("\n---Letters---\n");
        /*
        A obj1 = new A();
        B obj2 = (B) obj1;
        obj2.print(); // You said B, prints ClassCastException
        */

        System.out.println("\n---Date Time Formatter---");
        LocalDate date = LocalDate.of(2012,1,11);
        Period period = Period.ofMonths(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        System.out.println(formatter.format(date.minus(period))); //prints 11-11-11


        //args already defined shows error
        //short[] args = new short[]{50,50};
        //args[0] = 5;
        //args[1] = 10;
       // System.out.println("[" + args[0] + "," + args[1] + "]");

    }
}
