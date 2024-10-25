package leetCode;

import java.util.*;

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

    public static int[] twoSumAdv(int[] nums, int target) {
        for(int i =0;i< nums.length;i++){
            for(int j =0;j< nums.length;j++){
                if(i != j) {
                    if (nums[i] + nums[j] == target ) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{1};
    }
    public static int[] twoSumHashMap(int[] nums, int target){

        Map<Integer, Integer> checkedNumbers = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){

            int currentNumber = nums[i]; //2
            int targetValue = target - currentNumber; //7

            if(!checkedNumbers.containsKey(currentNumber)){
                checkedNumbers.put(nums[i], i);
            }

            if(checkedNumbers.containsKey(targetValue)){
                return new int[] {i, checkedNumbers.get(targetValue)};
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//
//        int[] arr = {2, 7, 11,15};
//        System.out.println(Arrays.toString(twoSum(arr, 9)));

        int[] arr1 = {3,2,4};
        System.out.println(Arrays.toString(twoSumAdv(arr1, 6)));
    }
}
