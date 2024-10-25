package leetCode;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static int removeDuplicates(int[] nums){

        int count = 0;
        int totalLength = nums.length - 1;
        int[] holdDuplicates = new int[nums.length];

        createDuplicates(holdDuplicates, nums);

        for(int i = 0; i < nums.length; i++){
                int currentIndex = nums[i];

                for(int j = i + 1; j < nums.length; j++){
                    //if not equal/repeating stick number in front
                    if(currentIndex == nums[j]) {
                        nums[i] = 9999;
                        count++;
                        break;
                    }
                }

        }

        Arrays.sort(nums);

        return nums.length - count;
    }

    public static void createDuplicates(int[] duplicate, int[] values){

        for(int i =0; i < values.length; i++) {
            duplicate[i] = values[i];
        }
    }

    public static void main(String[] args) {

        int[] duplicateAnswer = new int[]{removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})};

        for(int i: duplicateAnswer){
            System.out.println(i);
        }
    }

}
