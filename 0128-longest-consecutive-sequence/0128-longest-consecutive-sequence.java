class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num,Boolean.FALSE);
        }
        int maxLen = 1;
        for(int num : nums){
            int currLen = 1;
            int nextNum = num+1;

            //look for the next number
            while(map.containsKey(nextNum) && !map.get(nextNum)){
                map.put(nextNum,Boolean.TRUE);
                currLen++;
                nextNum++;
            }

            int prevNum = num-1;
            //look for the previous number
            while(map.containsKey(prevNum) && !map.get(prevNum)){
                map.put(prevNum,Boolean.TRUE);
                currLen++;
                prevNum--;
            }

            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}