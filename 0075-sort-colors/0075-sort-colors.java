class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start=0,mid=0,end=n-1;
        while(mid <= end){
            switch(nums[mid]){
                case 0 : swap(nums,start,mid);
                        start++;
                        mid++;
                        break;
                case 1 : mid++;
                        break;
                case 2 : swap(nums,mid,end);
                        end--;
            }
        }
    }
}