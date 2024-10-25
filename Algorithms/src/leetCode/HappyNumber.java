package leetCode;

public class HappyNumber {

    public boolean isHappy(int n) {
        int sum = 0;
        int count = 0;
        int sumHolder;
        if(n < 0){
            return false;
        }

        sum = n;
        while(sum != 1){

            sumHolder = 0;
            // step 1, separate take numbers into array

            int[] initialValue = turnToArray(sum); //[2] [4], []

            for(int i = 0; i < initialValue.length; i++){

                int square = initialValue[i] * initialValue[i];
                sumHolder +=  square;
                sum = sumHolder;
            }

            if(sum == 1){
                return true;
            }

            count++;

            if(count > 9){
                return false;
            }
        }

        return  true;
    }

    public int[] turnToArray(int numbers){
        String nSquaredString = String.valueOf(numbers);
        char[] arrayOfSquare = nSquaredString.toCharArray();
        int[] arrayOfNumbers = new int[arrayOfSquare.length];

        for (int i = 0; i < arrayOfSquare.length; i++) {
            int valueOf = Integer.parseInt(String.valueOf(arrayOfSquare[i]));
            arrayOfNumbers[i] = valueOf;
        }

        return arrayOfNumbers;
    }
}
