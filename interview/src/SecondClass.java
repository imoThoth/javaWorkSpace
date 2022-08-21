import java.util.Scanner;

public class SecondClass {

    public static void main(String[] args){

        //Variable type Scanner
        //Variable name read input
        //Create a new Scanner and call System.in
        Scanner readInput = new Scanner(System.in);

        System.out.println("Please input a name ");

        //Read a input from the user
        //Create a variable of type string, called name, and call readInput.
        String name = readInput.nextLine();

        System.out.println("Your name is " + name);

        System.out.println("Please enter your last name");
        String lastName = readInput. nextLine();

        System.out.println("Your last name is " + lastName);

        String fullName = name + " " + lastName;

        System.out.println("Your full name is " + fullName);

    }
}
