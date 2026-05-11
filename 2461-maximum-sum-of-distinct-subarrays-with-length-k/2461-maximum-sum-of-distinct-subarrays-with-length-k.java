class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long maxSum = 0;

        Set<Integer> set = new HashSet<>();
        int right=0,left=0;

        while(right < n){
            //to remove duplicates
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];

            //if len exceeds k
            while(right-left+1 > k){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            if(right-left+1 == k){
                maxSum = Math.max(maxSum,sum);
            }
            right++;
        }
        return maxSum;
    }
}