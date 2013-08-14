public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
    		return 0;
    	}
    	int min = prices[0];
    	int max = prices[0];
    	int maxProfit = 0;
    	int currProfit = 0;
    	int [] profitArray = new int [prices.length];
    	profitArray[0] = 0;
    	for (int i = 1; i < prices.length; ++i) {
    		if (prices[i] > max) {
    			max = prices[i];
    			currProfit = max - min;
    			if (currProfit > maxProfit) {
    				maxProfit = currProfit;
    				profitArray[i] = maxProfit;
    			} else {
    				profitArray[i] = profitArray[i - 1];
    			}
    		} else if (prices[i] >= min && prices[i] <= max) {
    			profitArray[i] = profitArray[i - 1];
    		} else {
    			min = prices[i];
    			max = prices[i];
    			profitArray[i] = profitArray[i - 1];
    		}
    	}
    	
    	int totalMax = 0; 
    	min = prices[prices.length - 1];
    	max = prices[prices.length - 1];
    	int currMax = 0;
    	for (int j = prices.length - 2; j >= 0; --j) {
    		int leftMax = 0;
    		if (j >= 1) {
    			leftMax = profitArray[j - 1];
    		}
    		if (prices[j] < min) {
    			min = prices[j];
    		} else if (prices[j] >= min && prices[j] <= max) {
    			continue;
    		} else {
    			min = prices[j];
    			max = prices[j];
    		}
    		currMax = max - min;
    		totalMax = Math.max(totalMax, leftMax + currMax);
    	}
    	return totalMax;
    }
}
