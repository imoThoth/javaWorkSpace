import java.util.function.IntPredicate;

public class Main {

    public static void main(String[] args) {
	// write your code here

        IntPredicate intCheck = i -> i > 15;
        IntPredicate evenCheck = i -> i % 2 == 0;
        System.out.println("Check if number is more than 15: " + intCheck.test(8));

        System.out.println("================== Int Check =================================");
        for(int i = 2; i < 40; i++){
            System.out.println("Check if number " + i + " is more than 15: " + intCheck.test(i));

        }

        System.out.println("================== Even Check =================================");
        for(int i = 2; i < 40; i++){
            System.out.println("Check if number " + i + " is Even: " + evenCheck.test(i));
        }

        System.out.println("================== Chaining Predicates =================================");
        for(int i = 2; i < 40; i++){
            System.out.println("Check if number " + i + " is Even and More than 15: " + intCheck.and(evenCheck).test(i));
        }
    }
}
