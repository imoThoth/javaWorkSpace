package JavaCollections.Generics;

import java.util.ArrayList;
import java.util.List;

/**Bounds
 * -Bounded parameter type = generic type that specifies a bound for the generic
 *
 *-Wildcard generic type = unknown generic type represented with a question mark(?)
 *
 * **/
public class Bounds {

    public static void main(String[] args){
        List <String> keywords = new ArrayList<>();
        keywords.add("Juggernaut");
        printList(keywords);
    }
    //Unbounded Wild cards
    public static void printList(List<?> list){
        for(Object x : list){
            System.out.println(x);
        }
    }
    
    //UpperBounded Wild Cards
    //any(?) class which extends usedClass(Number) can be used as a formal parameter type
    //UpperBounded wild cards are immutable
    //UpperBounded generics are always extended, like annonymous classes
    public static long total(List<? extends Number> list){
        long count = 0;
        for(Number number: list)
            count+= number.longValue();
        return count;
    }

    //LowerBounded Wild Cards
    //any(?)class which is a superclass of String
    public static void addSound(List<? super String> list){
        list.add("quack");
    }
    
    
}
