class Solution {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr,int i,int j){
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n-2;
        while(pivot >= 0 && nums[pivot] >= nums[pivot+1]){
            pivot--;
        }
        if(pivot == -1){
            reverse(nums,0,n-1);
            return;
        }
        int idx = pivot+1;
        int maxIdx = n - 1;

        while (nums[maxIdx] <= nums[pivot]) {
            maxIdx--;
        }
        
        swap(nums,pivot,maxIdx);
        reverse(nums,pivot+1,n-1);
    }
}