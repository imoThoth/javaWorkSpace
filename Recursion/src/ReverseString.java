public class ReverseString {

    public static String reverseString(String input){
        // stopping condition/ break / base-case
        if(input.equals("")){
            return "";
        }
        // problem space
        return  reverseString(input.substring(1)) + input.charAt(0);
    }


    public String mysteryFive(String aString) {
        int length = aString.length();
        if (length == 0) return "";
        else return aString.substring(length-1, length) + mysteryFive(aString.substring(0, length - 1));
    }

    public static void main(String[] args) {

        System.out.println(reverseString("Tosin"));

        String tryIt = "Innovative";

        String c = "abcd".substring(1);

        System.out.println(c);

        System.out.println(tryIt.substring(1, tryIt.length() -1));

    }
}
