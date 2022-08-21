import java.util.Arrays;

public class Main {

    static String toJadenCase(String phrase) {
        //Check if first letter is to Uppercase
        //if it is not, change to upper case
        //iterate through each characters until empty space
        //check if letter after empty case is toUpperCase
        //return string
        if(phrase.isEmpty()){
            return null;
        }

        String[] phraseArray = phrase.split("");
        for(int i = 0; i < phraseArray.length; i++){
            String keep = phraseArray[i].toUpperCase()
        }



        String solve = "";
        for(int i = 0; i < phrase.length(); i++){
            if(!(phrase.charAt(0) == Character.toUpperCase(phrase.charAt(0)))){
                solve += Character.toUpperCase(phrase.charAt(i));
            }
           // solve += phrase.charAt(i);
        }
        //System.out.println(phrase.replaceAll("^[a-z]",Character.toUpperCase(i)));

        return solve;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(toJadenCase("this aint nothing special"));

        String a = "This is a new phrase";
        String[] newWord = a.split("");
        System.out.println(a.length());
        System.out.println(Arrays.toString(newWord));
    }
}
