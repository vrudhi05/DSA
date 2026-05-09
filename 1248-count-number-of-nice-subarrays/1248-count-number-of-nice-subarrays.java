class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        int right = 0, left = 0, count = 0;
        while (right < n) {
            if (nums[right] % 2 == 1) {
                count++;
            }
            while (count > k) {
                if (nums[left] % 2 == 1) {
                    count--;
                }
                left++;
            }
            if (count == k) {
                int tmpLeft = left;
                while (nums[tmpLeft] % 2 == 0) {
                    tmpLeft++;
                }
                ans += (tmpLeft - left + 1); 
            }
            right++;
        }
        return ans;
    }
}