import java.util.Scanner;

public class SmallestInteger {

    public static int findSmallestInt(int[] args) {

        int smallest = args[1];
        for(int i : args){
            if(i < smallest){
                smallest = i;
            };
        }
        return smallest;
    }

    public static void main(String[] args) {

        System.out.println(findSmallestInt(new int[] {10, 20, 30, 40 , 60, 8}));
    }
}
