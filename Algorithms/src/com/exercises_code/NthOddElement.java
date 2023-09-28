package com.exercises_code;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO To Be Yet Understood
 */

public class NthOddElement {

    public Integer getElement(List<Integer> list, Integer n){

        int elementIndex = 2 * (n - 1);
        int getListSize = list.size() -1;

        if(n > getListSize){
            return -1;
        }

        return list.get(elementIndex);
    }

    public static Integer getElementInline(List<Integer> list, Integer n){
        int elementIndex = 2 * (n - 1);
        return  elementIndex > list.size() -1 ? -1 : list.get(elementIndex);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20); list.add(40); list.add(51); list.add(31); list.add(23); list.add(11);

        System.out.println(getElementInline(list, 4));
    }
}
