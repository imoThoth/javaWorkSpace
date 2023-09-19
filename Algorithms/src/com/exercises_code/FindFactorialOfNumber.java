package com.exercises_code;

public class FindFactorialOfNumber {

    public static int getFactorial(int n){
        //Factorial of 4 = 4x3x2x1 = 24
        int factorial = n;

        for(int i = n - 1 ; i > 0 ; i--){
           factorial = factorial * i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }
}
