public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length == 0) {
            return 0;
        }
        
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > max) {
                max = prices[i];
                profit = Math.max(profit, max - min);
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        
        return profit;
    }
}
