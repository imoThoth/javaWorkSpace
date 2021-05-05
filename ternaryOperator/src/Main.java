import java.sql.SQLOutput;

public class Main {

    public static int max1(int a, int b){
        if(a > b){
            return a;
        } else{
            return b;
        }
    }

    public static int max2(int a, int b){
        //if a more than b return a
        //else return b
        //question mark acts as then
        //colon acts as else
        return a > b ? a : b;
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Without Ternary");
        int ans = max1(5,7);
        System.out.println(ans);
        System.out.println("\nWith Ternary");
        int ans2 = max2(5,25);
        System.out.println(ans2);
    }
}
