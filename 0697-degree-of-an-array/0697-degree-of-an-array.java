class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int maxFreq = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!first.containsKey(nums[i])){
                first.put(nums[i],i);
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            last.put(nums[i],i);
            maxFreq = Math.max(freq.get(nums[i]),maxFreq);
        }
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(freq.get(nums[i]) == maxFreq){
                int len = (last.get(nums[i])-first.get(nums[i]))+1;
                minLen = Math.min(minLen,len);
            }
        }
        return minLen;
    }
}