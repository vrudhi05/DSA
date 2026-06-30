class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}