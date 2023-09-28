package com.exercises_code;

import java.util.Scanner;

public class Fibonnaci {

    public static void main(String[] args) {

        int n = 10;
        int firstNum = 0;
        int secondNum = 1;

        for(int j = 0; j < n; j++){

            System.out.println(firstNum); //print 0, 1, 1

            int compute = firstNum + secondNum; //1, 2
            firstNum = secondNum; //1, 1
            secondNum = compute; // 1, 2
            

        }



    }
}
