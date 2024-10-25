package leetCode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        //Turn number into string#
        //Check if the strin values are equal#
        //if true, return
        String value = String.valueOf(x);
        StringBuilder reverseValue = new StringBuilder();
        reverseValue.append(value);
        reverseValue.reverse();

        return value.equals(reverseValue.toString());

    }

    public static void main(String[] args) {

    }
}
