import java.util.HashMap;

class Main {

     public static int recusiveFib(int n) {
         return recusiveFib(n, new HashMap<>());
     }

    /**
     * Recursive fibonacci using memoisation
     * Each value of n is stored in the hashmap
     * Which can be retrieved and save on run time
     * @param n
     * @param memo
     * @return
     */
     public static int recusiveFib(int n, HashMap<Integer, Integer> memo){

        if(n == 0 || n == 1){
            return n;
        }
        // checks to see if the memo contains the key
        if(memo.containsKey(n)){
          return memo.get(n);
        }

        int result = recusiveFib(n - 1, memo) + recusiveFib(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 1, 1, 2, 3, 5, 8, 13, 21
        int firstNum = 0;
        int secondNum = 1;

        for(int i = 0; i <= 6 ; i++){

            System.out.println(firstNum);

             int storeCalculation = firstNum + secondNum;
             secondNum = firstNum;
             firstNum = storeCalculation;
        }

        System.out.println(recusiveFib(10000));

    }
}