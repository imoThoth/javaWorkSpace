package leetCode;

public class ValidPalindrome {


    private static boolean isPalindrome(String s){

        //remove any non-alphanumeric characters
        // "^" means not. Replace all character that is NOT "a-zA-Z0-9"
        String word = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        //check if string is suitable for automatic palindrome
        if(word.length() < 2){
            return true;
        }

        int wordLength = word.length();
        int lastElementIndex = wordLength - 1;
        int firstElementIndex = 0;
        int midPoint = wordLength / 2;

        for(int i = 0; i < wordLength; i++){

            String frontLetter = String.valueOf(word.charAt(firstElementIndex));
            String backLetter = String.valueOf(word.charAt(lastElementIndex));

            if(!frontLetter.equals(backLetter)){
                break;
            }

            lastElementIndex--; firstElementIndex++;

            if(firstElementIndex > midPoint || lastElementIndex < midPoint){
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("./ "));
    }
}
