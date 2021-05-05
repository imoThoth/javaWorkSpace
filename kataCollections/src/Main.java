import java.util.ArrayList;

public class Main {

    public static int sum(int[] arr){

        int store = 0;
        int i = 0;

        while(i < arr.length){
            if(i > 0 && i % 2 == 0) {
                store += i;
            }
            i++;
        }
        return store;
    }

    public static String camelCase(String str){
        //remove String
        //change words to camel case
        String[] newWord = str.split("\\s");
        String show = "";

        //print out each individual word within array newWord, add the word to String j
       for(String j : newWord){
           //within the word j, iterate through each character
           for(int i = 0; i < j.length(); i++)
               //take the first character and replace with uppercase
               j = j.replace(j.charAt(0), Character.toUpperCase(j.charAt(0)));
               //take this word, and add it to show
               show += j;
       }
        return show;
    }

    public static String[] dup(String[] arr){

//        for(String word : arr){
//
//        }
//        return "";
//    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }



    public static void main(String[] args) {
	// write your code here

        dup(new String[]{"ukeeleels", "dooggaama"});

//        int ans = sum(new int[] {1,2,3,4,5});
//        System.out.println(ans);
//
//        String str = "Example of a goddamn String";
//        String[] arrStr = str.split("\\s");
//        String word = arrStr[0];
//
//        for(String i: arrStr){
//            System.out.println(i);
//        }

//        System.out.println("Camel Case: " + camelCase("a camel sitting down"));

//        System.out.println("Ukellele");
//
//        String word = "A whole new world to see";
//        String newWord = word.substring(0,1);
//        System.out.println(newWord);


//        char[] words = word.toCharArray();
//        System.out.println(words);
//        for(char box : words){
//            System.out.println(box);
//        }

    }
}
