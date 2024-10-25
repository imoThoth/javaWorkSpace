package leetCode;

import java.util.*;

public class PartitionLabels {

    public static List<Integer> partionLabels(String s){

        Map<String, Integer> partionList = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        String[] noPartionLetters = s.split("");

        for(int i = 0; i < noPartionLetters.length; i++){
            partionList.put(String.valueOf(s.charAt(i)), i);
        }

        for(int i = 0; i < s.length(); i++){

            int totalLetters = i;
            int maxPartition = partionList.get(String.valueOf(s.charAt(i)));

            while(i < maxPartition){

                if(partionList.get(String.valueOf(s.charAt(i))) > maxPartition){
                    maxPartition = partionList.get(String.valueOf(s.charAt(i)));
                }

                i++;
            }

            int result = (maxPartition + 1) - totalLetters;

            integerList.add(result);

        }

        System.out.println(partionList.get("a"));

        return integerList;
    }

    public static void main(String[] args) {

        System.out.println(partionLabels("eccbbbbdec"));

    }
}
