package leetCode;

//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

public class MergeSortedArray {

    //num 1 and num 2, arrays stored in non-decreasing order
    // m and n, represents elements in nums1 and nums2

    // MERGE num 1 and num2 into single array of non-decreasing order
    //final solution to be stored inside num1
    public static void merge(int[] num1, int m, int[] num2, int n){

        //take an element inside num2
        //check if it is small or bigger than any element in num1
        //put it to the left of any element it is equal to
        //put it to the right of any element it is smaller than

        int[] storedArray = new int[m + n];

        for(int secondArray = 0; secondArray <= num2.length - 1; secondArray++){

            int elementBeingAdded = num2[secondArray];

            for(int firstArray = 0; firstArray <= num1.length - 1; firstArray++){

                int currentElementInFirstArr = num1[firstArray];

                if(currentElementInFirstArr != 0){
                    //ignore
                    if(elementBeingAdded <= currentElementInFirstArr){
                        storedArray[firstArray] = elementBeingAdded;
                        storedArray[firstArray + 1] = currentElementInFirstArr;
                        continue;
                    }
                }

                System.out.println(storedArray[firstArray]);

            }
        }

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Indices for the last elements in nums1 and nums2, and the last position in nums1
        int index1 = m - 1; // Last element index in the actual elements of nums1
        int index2 = n - 1; // Last element index in nums2
        int mergeIndex = m + n - 1; // Last position in nums1 where the merged element should be placed

        // Merge in reverse order to avoid overwriting elements in nums1 that haven't been checked yet
        while (index1 >= 0 && index2 >= 0) {
            // Compare elements from nums1 and nums2 from the end, placing the larger one in the correct position
            if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex] = nums1[index1];
                index1--;
            } else {
                nums1[mergeIndex] = nums2[index2];
                index2--;
            }
            mergeIndex--;
        }

        // If there are remaining elements in nums2, copy them
        // This loop is needed because if nums2 contains smaller elements, they need to be moved to the front
        while (index2 >= 0) {
            nums1[mergeIndex] = nums2[index2];
            index2--;
            mergeIndex--;
        }

        // No need to handle remaining elements in nums1 as they are already in the correct place
    }


    public static void main(String[] args) {

        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        merge(num1, 3, num2, 3);
    }
}
