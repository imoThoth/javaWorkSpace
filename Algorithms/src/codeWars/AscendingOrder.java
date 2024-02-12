package codeWars;

import java.util.Arrays;

public class AscendingOrder {

    public static int sortAsc(final int num){

        //Sort the number into ascending order
        //Step 1, turn the number into an array
        //Step 2, compare values within the array
        //Step 3, Store the highest value in string builder
        //Step 4, Change the value in String builder into an integer
        //Step 5, Return this value

       //Step 1
        String turnNumToString = String.valueOf(num);

        int[] numArr = new int[turnNumToString.length()];
        for(int i = 0; i < turnNumToString.length(); i++){
            numArr[i] = Character.getNumericValue(turnNumToString.charAt(i));
        }

        //Step 2
        int[] arrayToReturn = new int[numArr.length];
        for(int i = 0; i < numArr.length; i++){
            int a = numArr[i];
        }



        return 0;
    }

    public static void main(String[] args) {

        String newVal = String.valueOf(912031209);

//        int a = 9;
//        String b = String.valueOf(a);
//
//        System.out.println(b);

//        char[] newValArr = newVal.toCharArray() ;
        int[] intArr = new int[newVal.length()];

        for (int j = 0 ; j < newVal.length(); j++) {
            intArr[j] = Character.getNumericValue(newVal.charAt(j));
            System.out.println(intArr[j]);
        }

//        for (int j = 0 ; j < intArr.length; j++) {
//            System.out.println(intArr[j]);
//            System.out.println(Integer.valueOf(intArr[j]));
//            System.out.println(Integer.valueOf(intArr[j]) instanceof Integer);
//        }
    }
}
