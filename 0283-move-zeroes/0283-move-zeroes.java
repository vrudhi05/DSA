class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        int n=nums.length;
        for(int num:nums){
            if(num!=0){
                nums[index++]=num;
            }
        }
        for(int i=index;i<n;i++){
            nums[i]=0;
        }
    }
}