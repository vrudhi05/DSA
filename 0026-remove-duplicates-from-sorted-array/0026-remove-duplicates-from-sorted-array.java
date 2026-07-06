class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[index++]=nums[i];
            }
        }
        return set.size();
    }
}