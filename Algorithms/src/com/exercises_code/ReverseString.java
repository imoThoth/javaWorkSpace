package com.exercises_code;

public class ReverseString {

    public static String getReveresedString(String word){

        char[] arr = word.toCharArray();
        StringBuilder reversedWord = new StringBuilder();

        for(int i = arr.length-1; i >= 0; i--){
            reversedWord.append(arr[i]);
        }
        //take the string and break it into indidual charaacters
        return reversedWord.toString();
    }

    public static String givenAnswer(String word){

        String result = "";
        for(int i = 0; i < word.length(); i++){
            result += word.charAt(word.length() - i - 1);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(getReveresedString("Ourangantang"));
    }
}
