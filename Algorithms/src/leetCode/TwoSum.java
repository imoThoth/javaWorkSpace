package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static int[] twoSum(int[] num, int target){

        int firstIteration;
        int secondIteration;
        int[] arr = new int[2];

        for(int i = 0; i < num.length; i++){
            firstIteration = num[i];
            System.out.println("The int i " + (num[i]));
           for(int j = i + 1; j < num.length; j++){
               secondIteration = num[j];
               System.out.println("The int j " + (num[j]));
               int sumStore = firstIteration + secondIteration;
               System.out.println("Sum store " + sumStore);
               if(target == sumStore){
                   return new int[] {i , j };
               }
           }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));

        int[] arr1 = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr1, 6)));
    }
}
