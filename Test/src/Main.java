public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Expected 36, Actual: " + animals(2,3, 5) );
        System.out.println("Expected 20. Actual: " + shiftToLeft(5,2));

    }

    public static int animals(int chickens, int cows, int pigs){
        int total = 0;
        int[] farmAnimals = {chickens, cows, pigs};
            for(int i =0; i < farmAnimals.length; i++){
                if(i == 0){
                    total += 2 * farmAnimals[i];
                } else{
                    total += 4 * farmAnimals[i];
                }
            }
            return total;
    }

    public static int shiftToLeft(int x , int y){
        int powerResult = (int)Math.pow(2,y);
        int calc = x * powerResult;
        return calc;
    }

}
