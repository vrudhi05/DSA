class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<n;i++){
            sum += nums[i];
            int diff = sum - k;
            cnt += map.getOrDefault(diff,0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}