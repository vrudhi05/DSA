class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0, middle = 0, end = n-1;
        while(middle <= end){
            if(nums[middle] == 0){
                swap(nums,middle,start);
                start++;
                middle++;
            }
            else if(nums[middle] == 1){
                middle++;
            }
            else{
                swap(nums,middle,end);
                end--;
            }
        }
    }
}