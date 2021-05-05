import java.net.URL;

public class Main {

    public static void main(String[] args) {

        //Creating a catch exception
        //   String str = "A char string";
        //prints out before problem
        // System.out.println("Before problem");
        // char ch = str.charAt(21);
        //call to char fails, charAt method parameter out of bound
        //code will show nothing when run
        //System.out.println(ch);
        //System.out.println("After Problem");

        try {
            String str = "A char string";
            //runs this section of the code
            System.out.println("Before problem");
            char ch = str.charAt(20);
            System.out.println("After problem");
        } catch (StringIndexOutOfBoundsException e) {
            //jumps to this section if, it is out of bounds
            System.out.println("Hey - your string is not so big");
        }

        //Exception Object
        try{
            String str = "The beautiful Eleanor";
            System.out.println("Before Problem");
            char ch = str.charAt(20);
            System.out.println("After Problem");
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Problem in main " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\n\n\n");
        //Checked(RunTime) vs Unchecked
    }
}
