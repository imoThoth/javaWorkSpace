import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFTP(x,y));
//        System.out.println(divide(x,y));
//        int x = getIntLBYL();
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return  s.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
            if (isValid) {
                return Integer.parseInt(input);
            }
        //}
        return 0;
    }

    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an interger");
        try{
            return s.nextInt();
        } catch(InputMismatchException e){
            return 0;
        }
    }

    //Look before you leap method
    //Find the exceptions and handle them
    private static int divideLBYL(int x, int y){
        if (y != 0){
            return x/y;
        } else{
            return 0;
        }
    }

    //Easier asking forgiveness than permission
    private static int divideEAFTP(int x, int y){
        try{
            return x /y;
        } catch(ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x/y;
    }
}
