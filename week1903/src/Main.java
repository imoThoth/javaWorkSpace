import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input two numbers");
        int input = Integer.parseInt(scanner.nextLine());
        int input2 =Integer.parseInt(scanner.nextLine());

//        double big = Math.abs(input);
//        double bigger = Math.abs(input2);
//
//        if(big > bigger){
//            System.out.println("Input " + input + " is bigger");
//        } else{
//            System.out.println("Input2 " + input2 + " is bigger");
//        }

        int compare = Math.max(input, input2);
        System.out.println("This bigger number is " + compare);

    }
}

