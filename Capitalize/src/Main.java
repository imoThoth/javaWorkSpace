import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code her
        Scanner input = new Scanner(System.in);
        String passengerType = null;
        double distance = 0;
        double minimumFare = 20;
        double fare1, finalFare;

        try {
            System.out.println("Enter the type of Passenger (Ordinary/Student/Senior): ");
            passengerType = input.nextLine();
            System.out.println("Enter the Distance: ");
            distance = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Please enter strings for passenger and numbers for distance " + e);
        }

        // Condition for "Ordinary Passenger"
        if (passengerType.equalsIgnoreCase("Ordinary"))
        {
            if (distance <= 10)
            {
                System.out.println("Your Fare is: "+minimumFare);
            }
            else if (distance > 10)
            {
                fare1 = (distance - 10) * 2.50;
                finalFare = fare1 + minimumFare;
                System.out.println("Your Fare is: "+finalFare);
            }
        }
        // Condition for "Student Passenger"
        else if (passengerType.equalsIgnoreCase("Student"))
        {
            if (distance <= 10)
            {
                finalFare = 20 - (20 * 0.20);
                System.out.println("Your Fare is: "+ finalFare);
            }
            else if (distance > 10)
            {
                fare1 = ((distance - 10) * 2.50);
                finalFare = fare1 + 20 - ((fare1 + 20) * 0.20);
                System.out.println("Your Fare is: "+finalFare);
            }
        }
        // Condition for "Senior Passenger"
        else if (passengerType.equalsIgnoreCase("Senior"))
        {
            if (distance <= 10)
            {
                finalFare = 20 - (20 * 0.30);
                System.out.println("Your Fare is: "+ finalFare);
            }
            else if (distance > 10)
            {
                fare1 = ((distance - 10) * 2.50);
                finalFare = fare1 + 20 - ((fare1 + 20) * 0.30);
                System.out.println("Your Fare is: "+ finalFare);

            }
        }
    }
}
