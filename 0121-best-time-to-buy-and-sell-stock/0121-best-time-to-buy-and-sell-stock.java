class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int nextMax = prices[n-1];
        int profit = Integer.MIN_VALUE;
        int diff = 0;

        for(int i=n-1;i>=0;i--){
            int suffix = nextMax;
            diff = Math.max(diff,suffix-prices[i]);
            nextMax = Math.max(nextMax,prices[i]);
        }
        return diff;
    }
}