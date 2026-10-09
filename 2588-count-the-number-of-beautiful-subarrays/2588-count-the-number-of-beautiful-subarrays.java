class Solution {
    public long beautifulSubarrays(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        Map<Long,Long> map = new HashMap<>();
        map.put(0L,1L);
        long xor = 0;

        for(int i=0;i<n;i++){
            xor ^= nums[i];
            cnt += map.getOrDefault(xor,0L);
            map.put(xor,map.getOrDefault(xor,0L)+1);
        }
        return cnt;
    }
}