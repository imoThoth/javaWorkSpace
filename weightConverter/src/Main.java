import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
    * Jay and Silent Bob have been given a fraction of an ounce but they only understand grams.
        Convert a fraction passed as a string to grams with up to two decimal places.
        An ounce weighs 28 grams.
        *
        * jayAndBob("half") ➞ "14 grams"

        jayAndBob("quarter") ➞ "7 grams"

        jayAndBob("eighth") ➞ "3.5 grams"
        *
        */
        System.out.println("Enter the amount in grams");
        Scanner input = new Scanner(System.in);

        String userInput = input.nextLine();
        switch(userInput){

            case("ounce"):
                System.out.println("28 grams");
                break;

            case("Seven Eights"):
                System.out.println("24 grams");
                break;

            case("Six Eights"):
                System.out.println("21 grams");
                break;

            case("Five Eights"):
                System.out.println("17.5 grans");
                break;

            case("half"):
                System.out.println("14 grams");
                break;

            case("three eights"):
                System.out.println("10.5 grams");
                break;

            case("quarter"):
                System.out.println("7 grams");
                break;

            case("one eights"):
                System.out.println("3.5grams");
                break;
        }

    }
}
