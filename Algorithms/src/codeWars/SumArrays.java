package codeWars;

import java.util.Arrays;

public class SumArrays {

    public static double sum(double[] numbers){

        double ans = 0.0;

        for(double count = 0; count < numbers.length; count++){

            double currentElement = numbers[(int) count];

            ans += currentElement;
        }

        return ans;
    }

    public static double sumEnhanced(double[] numbers){
        return Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {

        System.out.println(sum(new double[] {1, 5.2, 4, 0, -1}));


    }
}
