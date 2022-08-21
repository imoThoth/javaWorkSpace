import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Random random = new Random();
        Supplier<Integer> randomizeInt = () -> random.nextInt(100) + 1;

        System.out.println("=============================================");
        for(int i = 0; i < 10; i++){
            System.out.println(random.nextInt(100) + 1);
        }

        System.out.println("================================================");
        for(int i = 0; i < 10; i++){
            System.out.println(randomizeInt.get());
        };
    }
}
