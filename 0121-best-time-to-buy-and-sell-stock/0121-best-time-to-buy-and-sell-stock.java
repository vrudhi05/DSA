class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxRight = new int[n];
        maxRight[n-1] = prices[n-1];
        int maxE = maxRight[n-1];
        for(int i=n-2;i>=0;i--){
            if(prices[i] > maxE){
                maxE = prices[i];
            }
            maxRight[i] = maxE;
        }
        int diff = 0;
        for(int i=0;i<n;i++){
            diff = Math.max(diff,maxRight[i] - prices[i]);
        }
        return diff;
    }
}