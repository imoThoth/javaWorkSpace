package miscWebsite;

public class BinarySearch {

    /**
     * Binary search method, method takes an array and target value,
     * and return the target value location inside the array.
     *
     * The method carries on while the min < = max.
     * Split the array in half and use that as the first guess
     * if the guess is higher than the value, we decrement the max to remove all other high numbers
     * if the guess is lowerr than the value, we increment the min to remove all lower numbers
     * and repeat splitting the array with the new min and max
     * @param numberArr
     * @param targetValue
     * @return
     */
    public static int binarySearch(int[] numberArr, int targetValue){

        //.length begins count at 1
        //retracting one lets us have the binary format
        int max = numberArr.length - 1;
        int min = 0;
        int guess = 0;

        while(min <= max ){

            guess = (int) Math.floor((min + max )/ 2);
            System.out.println(guess);

            if(numberArr[guess] == targetValue){
                return guess;
            }else if(numberArr[guess] < targetValue){
                min = guess + 1;
            }else if (numberArr[guess] > targetValue){
                max = guess - 1;
            }
        }
            return -1;
    }


    public static void main(String[] args) {

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};


        System.out.println(binarySearch(primes, 7));

    }
}
