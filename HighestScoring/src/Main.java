public class Main {

    public static String high(String s) {
        //allocate a score to each letter using array
        //combine the score of each letter using the array
        //we store the score in a variable
        //we compare old to new score
        //return new score

        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l",
                              "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


        String position = alphabet[0];
        String position3 = alphabet[alphabet.length-1];
        int position2 = alphabet.length;
        System.out.println("Lenght of array: " + position2 + " Return 26 - 1: " + position3 +
                           " Should return a: " + position );

        return "";
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(high("dog"));
    }
}
