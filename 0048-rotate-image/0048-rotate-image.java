class Solution {
    public void reverse(int[] arr){
        int n = arr.length;
        int left=0,right=n-1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse each row
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
    }
}