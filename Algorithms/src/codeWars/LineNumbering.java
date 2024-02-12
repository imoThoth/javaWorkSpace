package codeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineNumbering {

    public static List<String>number (List<String> lines) {

        if(lines.isEmpty()){
            return new ArrayList<String>();
        }

        ArrayList<String> result = new ArrayList<>();

        int count = 1;
        for(String singleWord : lines){
             if(!result.contains(singleWord)){
                 result.add(count + ": " + singleWord);
            }
            count++;

        }

        return result;
    }

    public static void main(String[] args) {

        LineNumbering.number(Arrays.asList("a", "b", "c")).forEach(System.out::println);

    }
}
