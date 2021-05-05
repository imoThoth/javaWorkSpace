import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> items = new ArrayList<>(); //uses generics to specify type
        //ArrayList items = new ArrayList(); does not use generics to specify type
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);

        printDoubled(items);
    }
    private static void printDoubled(ArrayList<Integer> n){
        for(int i: n){ //Generic specifies type of object
            //for(Object i : n) non generic, all arrays are objects
            //cast object into an integer
            System.out.println(i * 2); //generic does not need casting 
            //println((Integer)i * 2) non generic, cast object to type Integer
        }
    }
}
