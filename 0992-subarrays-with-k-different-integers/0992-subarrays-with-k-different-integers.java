class Solution {
    public static int atMostK(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int n = nums.length;
        int left=0,right=0,distinct=0;
        int[] hash = new int[20001];
        int ans = 0;

        while(right < n){
            if(hash[nums[right]] == 0){
                distinct++;
            }
            hash[nums[right]]++;
            while(distinct > k){
                hash[nums[left]]--;
                if(hash[nums[left]] == 0){
                    distinct--;
                }
                left++;
            }
            ans += (right-left+1);
            right++;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
}