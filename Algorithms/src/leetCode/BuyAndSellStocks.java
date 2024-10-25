package leetCode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different
 * day in the future to sell that stock.
 */
public class BuyAndSellStocks {

    private static int maxProfit_FAILSWHENPRICESMORETHAN800(int[] prices){

        int eazyPayDay = 0;

        for(int i = 0; i < prices.length; i++){
            int buyDay = -prices[i];
            for(int j = i + 1; j < prices.length; j++){
                int worth = buyDay + prices[j];
                if(worth > eazyPayDay){
                    eazyPayDay = worth;
                }
            }
        }

        return eazyPayDay;
    }

    private static int maxProfit_KadanesAlgorithm(int[] prices){

        int max_current = 0;
        int max_global = 0;

        for(int i = 1; i < prices.length; i++){

            int profit = prices[i] - prices[i - 1];

            max_current = Math.max(profit, max_current + profit);

            if(max_current > max_global){
                max_global = max_current;
            }
        }

        return max_global;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit_FAILSWHENPRICESMORETHAN800(new int[]{7,1,5,3,6,4}));

        System.out.println("Kadanes Algoruthm " + maxProfit_KadanesAlgorithm(new int[]{7,1,5,3,6,4}));
    }
}
