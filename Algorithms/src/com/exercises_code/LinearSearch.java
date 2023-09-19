package com.exercises_code;

public class LinearSearch {

    public static int search(Integer n, Integer[] list){

        for(int i = 0; i < list.length; i++){
            Integer comparison = list[i];
            if(n.equals(comparison)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] list = {1, 2, 3, 4, 5, 6};

        System.out.println(search(3, list ));
    }

}
