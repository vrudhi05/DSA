class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int vote = 1;

        for(int i=1;i<n;i++){
            if(nums[i] == candidate){
                vote++;
            }
            if(vote == 0){
                candidate = nums[i];
                vote++;
            }
            if(nums[i] != candidate){
                vote--;
            }
        }
        return candidate;
    }
}