class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int right=0,left=0;
        long ans = 0;
        long sum = 0;
        
        while(right < n){
            sum += (long)nums[right];
            while(((long)(sum * (right-left+1) ) >= k)){
                sum -= nums[left];
                left++;
            }
            ans += (right-left+1);
            right++;
        }
        return ans;
    }
}