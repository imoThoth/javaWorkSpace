public class SumOfAllNumbers {

    public static int recursiveSumOfNumbers(int inputNumber){

        // base condition
        if(inputNumber <= 1){
            return inputNumber;
        }

        // smallest process
        return inputNumber + recursiveSumOfNumbers(inputNumber - 1);
    }

    public static void main(String[] args) {

        int recursiveSum = recursiveSumOfNumbers(10);
        System.out.println("Recursive Sum: " + recursiveSum);
    }
}
