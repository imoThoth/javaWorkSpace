package com.exercises_code;

public class SumMultiplesOfThreeAndFive {

    public static int getSumMultiplesOfThreAndFive(int n){

        //find all numbers divisible by 3
        //find all numbers divisible by 5
        //add all together up to n
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 || i % 5 == 0){
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(getSumMultiplesOfThreAndFive(3));
    }
}
