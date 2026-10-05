class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = n*n;
        int reqSum = (m*(m+1))/2;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int repeatedEle=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!set.contains(grid[i][j])){
                    sum += grid[i][j];
                    set.add(grid[i][j]);
                }
                else{
                    repeatedEle = grid[i][j];
                }
            }
        }
        return new int[]{repeatedEle, reqSum-sum};
    }
}