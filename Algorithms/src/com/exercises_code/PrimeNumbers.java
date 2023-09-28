package com.exercises_code;

public class PrimeNumbers {

    public static Boolean isPrime(Integer i){

        //prime conditions
        // i is divisible by itself and 1
        // all numbers are divisible by themselves
        for(int a = i -1; a <= 1; a++){

            if(i % a == 0){
                return false;
            }
        }

        return true;
    }

    public static Boolean suggestedIsPrime(Integer n){

        boolean isPrime = true;

        for(int i = n -1; i > 1; i--){

            if(n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {

            ;
        System.out.println(isPrime(0));
    }
}
