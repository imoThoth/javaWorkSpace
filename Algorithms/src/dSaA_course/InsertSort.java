package dSaA_course;

import java.util.Arrays;

/**
 * Insertion Sort Algorithm - Rules/Steps
 *
 * 1. Initiate array from second element
 * 1.2
 * 2. Check if element in array is > first element swap if true
 * 3. Loop moves to third element, check first and second, swap elements if greater
 */

public class InsertSort {

    public static void main(String[] args) {

        int[] insertSortProblem = insertSort(new int[]{10, 8, 30, 50, 2, 9, 12, 7, 123});

        System.out.println(Arrays.toString(insertSortProblem));

    }

    public static int[] insertSort(int[] numArr){

        for(int i = 1; i < numArr.length; i++){

            int currentElement = numArr[i];

            int prevElement = numArr[i -1];

            while(prevElement > currentElement && i <= 0){


            }
        }

        return new int[]{};
    }
}
