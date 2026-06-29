class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int temp[] = new int[m+n];
        int index=0;

        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                temp[index++] = nums1[left++];
            }
            else{
                temp[index++] = nums2[right++];
            }
        }
        while(left < m){
            temp[index++] = nums1[left++];
        }

        while(right < n){
            temp[index++] = nums2[right++];
        }
        for(int i=0;i<temp.length;i++){
        nums1[i] = temp[i];
    }
    }
}