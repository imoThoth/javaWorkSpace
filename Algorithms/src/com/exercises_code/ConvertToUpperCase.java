package com.exercises_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUpperCase {

    public static List<String> upperCase(List<String> list){

        List<String> toUpperCase = new ArrayList<>();

        for(String item : list){
            int checkItemLength = item.length();
            String changeToUpperCase = "";

            if(checkItemLength >= 2){
                char[] storedItem = item.toCharArray();

                for(int i = 0; i < checkItemLength; i++){
                    changeToUpperCase += String.valueOf(storedItem[i]).toUpperCase() ;
                }
                toUpperCase.add(changeToUpperCase);
            }else{
                toUpperCase.add(item.toUpperCase());
            }
        }

        return toUpperCase;
    }

    public static List<String> upperCaseLambda(List<String> list){
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> toUpperCase = new ArrayList<>();
        toUpperCase.add("a"); toUpperCase.add("b"); toUpperCase.add("c");

//        toUpperCase.stream().forEach(i -> System.out.println("Before Method: " + i));
//        upperCase(toUpperCase).forEach(i -> System.out.println("After Method: " + i));

        toUpperCase.add("cerebus");

//        toUpperCase.stream().forEach(i -> System.out.println("Before Method: " + i));
//        upperCase(toUpperCase).forEach(i -> System.out.println("After Method: " + i));

        List<String> newList =  upperCaseLambda(toUpperCase);
//        upperCase(toUpperCase);
        for(String a: newList){
            System.out.println(a);
        }

    }
}
