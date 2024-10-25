package leetCode;

import java.util.Arrays;

public class SortArrayByParityII {

    /**
     * Sort array so
     * whenever nums[i] is odd, i is odd
     * whenever nums[i] is even, i is even
     * @param nums
     * @return
     */
    public static int[] sortArrayByParity(int[] nums){

        int evenPointer = 0;
        int oddPointer = nums.length - 1;

        for(int i = 0; i < nums.length; i++){

            //have two pointers at opposite ends of array
            //if both even pointer is odd and odd pointer is even, swap, decrement both
            //if even pointer is even, and odd pointer even, move even pointer up
            if(nums[evenPointer] % 2 != 0 && nums[oddPointer] % 2 == 0){
                int temp = nums[evenPointer];
                nums[evenPointer] = nums[oddPointer];
                nums[oddPointer] = temp;
                evenPointer+= 2;
                oddPointer-= 2;
            } else if(nums[evenPointer] % 2 == 0 && nums[oddPointer] % 2 ==0) {
                evenPointer+=2;
            }else if(nums[oddPointer] % 2 != 0 && nums[evenPointer] % 2 != 0){
                oddPointer -= 2;
            }else{
                evenPointer+= 2;
                oddPointer-= 2;
            }

            if(evenPointer > nums.length - 2 || oddPointer < 1){
                break;
            }
        }

        return nums;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortArrayByParity(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{2, 3})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{888,505,627,846})));
    }
}
