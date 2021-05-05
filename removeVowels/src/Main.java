public class Main {

    public static String disemvowel(String str) {
        //Function takes a string
        //return new string with all vowels removed
        //List out each letter in word
        //compare the letter to array of vowels
        //if the letters match remove their index
//        int i = 0;
//        String vowels = "AEIOU";
//        StringBuilder sb = new StringBuilder(str);
//        //String newWord = str;
            String extra = str.replaceAll("[AaEeIiOoUu]", "");
//
//        while(i < str.length()) {
//            for (int j = 0; j < vowels.length(); j++) {
//                if (sb.charAt(i) == vowels.charAt(i)) {
//                    sb.deleteCharAt(i);
//                } else {
//                    extra += sb.charAt(i);
//                }
//                    i++;
//            }
//            System.out.println(extra);
//        }
        return extra;


    }



    public static void main(String[] args) {
	// write your code here

        System.out.println( disemvowel("Atomic"));
    }

}
