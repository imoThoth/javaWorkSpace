package leetCode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums){

        int count = 0;

        if (nums.length < 3) {
            return nums.length;
        }
        for(int i = 0; i < nums.length; i++){
                int targetedElement = nums[i];
                int nextNumber = Math.min(i + 1 , nums.length - 1);
                int subsequentNumber = Math.min(i + 2, nums.length - 1) ;
                if(targetedElement == nums[nextNumber] && targetedElement == nums[subsequentNumber]){
                    nums[i] = 999;
                    count++;
                }

                if(subsequentNumber == nums.length -1){ break;}
        }

        Arrays.sort(nums);
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] ans = new int[]{removeDuplicates(new int[]{1})};

        for(int a : ans){
            System.out.println(a);
        }

    }
}
