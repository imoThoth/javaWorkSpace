package com.exercises_code;

import java.util.ArrayList;
import java.util.List;

public class AverageValue {

    public static Double getAverageValue(List<Integer> list){

        double answer;
        int listSize = list.size();
        answer = list.stream().mapToInt(i -> i).sum();

        return answer / listSize;
    }

    public static Double getAverageAnswer(List<Integer> list){
        return list.stream().mapToInt(i -> i).average().getAsDouble();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);

        System.out.println(getAverageValue(list));
        System.out.println(getAverageValue(list));
    }
}
