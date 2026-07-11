class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLen = 1;
        for(int num : set){
            if(!set.contains(num-1)){
                int cnt = 1;
                int currentNum = num;
                while(set.contains(currentNum+1)){
                    cnt++;
                    currentNum++;
                    maxLen = Math.max(maxLen,cnt);
                }
            }
        }
        return maxLen;
    }
}