package leetCode;

//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        //Array nums1 and nums2, stored in incrementing order
        //merge all numbers into nums1
        // int m and n = number of items to be merged in both array

        //length of nums1, gives me all the numbers needed in the array


        int leftIndex = m - 1; //current value in left index/nums1 array
        if(leftIndex < 0){
            leftIndex = 0;
        }
        int rightIndex = n - 1; //current value in right index/nums2 array
        int currentIndex = m + n - 1;

        while(leftIndex >= 0 && rightIndex >= 0){

            if(nums2[rightIndex] > nums1[leftIndex]){
                nums1[currentIndex] = nums2[rightIndex];
                rightIndex--;
            }else{
                nums1[currentIndex] = nums1[leftIndex];
                leftIndex--;
            }

            currentIndex--;
        }

    }

    public static void mergeEasy(int[] nums1, int m, int[] nums2, int n){
        int count = 0;
        for(int i = m; i < nums1.length; i++){
            nums1[i] = nums2[count];
            count++;
        }
        Arrays.sort(nums1);
    }


    public static void main(String[] args) {

        int[] num1 = {0};
        int[] num2 = {1};

        merge3(num1, 0, num2, 1);
    }
}
