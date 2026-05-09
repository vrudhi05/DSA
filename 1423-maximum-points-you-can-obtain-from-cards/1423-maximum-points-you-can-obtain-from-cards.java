class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum=0;
        int rsum=0;

        for(int i=0;i<k;i++){
            lsum += cardPoints[i];
        }

        int maxSum = lsum;
        int right=n-1;

        for(int i=k-1;i>=0;i--){
            rsum += cardPoints[right];
            lsum -= cardPoints[i];
            maxSum = Math.max(maxSum,(lsum+rsum));
            right--;
        }
        return maxSum;
    }
}