class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int suff = 1;
        int maxProd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prod == 0)prod=1;
            if(suff == 0)suff=1;
            prod *= nums[i];
            suff *= nums[n-i-1];
            maxProd = Math.max(maxProd,Math.max(suff,prod));
        }
        return maxProd;
    }
}