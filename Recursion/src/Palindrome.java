public class Palindrome {

    public static boolean isPalindrome(String input){

        // stop condition/ base condition
        if(input.length() == 0 || input.length() == 1){
            return true;
        }

        // smallest possible process to solve problem
        if(input.charAt(0) == input.charAt(input.length() -1)){
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        // base condition
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Desirree"));
    }
}
