class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] matrix = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j == 0 || i == j){
                    matrix[i][j] = 1;
                }
                else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
        }
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j=0;j<numRows;j++){
                if(matrix[i][j] != 0){
                    subList.add(matrix[i][j]);
                }
            }
            list.add(subList);
        }
        return list;
    }
}