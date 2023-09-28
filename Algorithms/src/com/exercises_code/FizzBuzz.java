package com.exercises_code;

public class FizzBuzz {

    public static String fizzBuzz(Integer i){

        //fizz multiple of 3
        //buzz multiple of 5
        //multiple of fizz buzz 3 and 5

        String option = "";

        if(i % 3 == 0 && i % 5 == 0 ){
            option = "fizzBuzz";
            return option;
        }else if(i % 3 == 0){

            option = "fizz";
            return option;
        } else if (i % 5 == 0) {

            option = "buzz";
            return option;
        }

        return i.toString();
    }

    public static String fizzBuzzSimp(Integer i){

        String result = "";

        if(i % 3 == 0){
            result += "Fizz";
        }

        if(i % 5 == 0){
            result += "Buzz";
        }

        if(result.equals("")){
            result += i.toString();
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(fizzBuzz(2));
    }
}
