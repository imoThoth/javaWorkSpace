package leetCode;

import java.util.*;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majorityElement = nums.length / 2;


        for (int i = 0; i < nums.length; i++) {
            int tick = 0;
            int checking = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (checking == nums[j]) {
                    tick++;

                }
            }
            map.put(nums[i], tick);
            int biggestMajority = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();

            if (biggestMajority > majorityElement) {
                break;
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int majorityElementDiamondBrains(int[] nums){
        Arrays.sort(nums);
        int middleElement = nums[nums.length / 2];
        //if the majority appears more than n / 2 times, it will always be one of the middle elements
        return middleElement;
    }

    public static void main(String[] args) {
//        int a = majorityElement(new int[]{3,2,3});
//        int b = majorityElement(new int[]{2,2,1,1,1,2,2});
        int c = majorityElement(new int[]{6,5,5});
//        System.out.println(a + ":a - b:" + b);
    }
}
