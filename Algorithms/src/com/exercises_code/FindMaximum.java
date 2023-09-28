package com.exercises_code;

public class FindMaximum {

    public static int findMaximumNum(Integer[] list){
        int max = 0;
        for(int i = 0; i < list.length; i++){
            if(max < list[i]){
                max = list[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Integer[] list = {0, 9, 1, 12, 9, 8, 4};
        System.out.println(findMaximumNum(list));
    }
}
