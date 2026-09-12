class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr= new int[n];
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];
        int posIdx=0;
        int negIdx=1;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                arr[posIdx] = nums[i];
                posIdx+=2;
            }
            else{
                arr[negIdx] = nums[i];
                negIdx+=2;
            }
        }
        posIdx=0;
        negIdx=1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[posIdx]=arr[i];
                posIdx += 2;
            }
            else{
                nums[negIdx]=arr[i];
                negIdx += 2;
            }
        }
        return nums;
    }
}