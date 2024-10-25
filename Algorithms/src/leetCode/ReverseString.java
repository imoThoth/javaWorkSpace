package leetCode;

import java.util.Arrays;

public class ReverseString {

    public static void reverseString(char[] s){

        int beginPointer = 0;
        int endPointer = s.length - 1;
        int midPoint = s.length / 2;

        for(int i = 0; i < s.length; i++){
            char near = s[beginPointer];
            char far = s[endPointer];

               //swap
               s[beginPointer] = far;
               s[endPointer] = near;

            //            swap(near, far);
            beginPointer++; endPointer--;

            if(beginPointer > midPoint || endPointer < midPoint){
                break;
            }
        }

    }

    private static void swap(char first, char last) {
        char hold = first;
        first = last;
        last = hold;
    }

    public static void main(String[] args) {

//        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] arr1 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        reverseString(arr);
        reverseString(arr1);

        System.out.println(new String(arr)); System.out.println(new String(arr1));
    }
}
