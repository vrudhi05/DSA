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
        for(int num : freq.keySet()){
            if(freq.get(num) == maxFreq){
                int len = (last.get(num)-first.get(num))+1;
                minLen = Math.min(minLen,len);
            }
        }
        return minLen;
    }
}