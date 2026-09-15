class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int rowBegin = 0, rowEnd = row-1;
        int colBegin = 0, colEnd = col-1;
        List<Integer> list = new ArrayList<>();

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            //traverse the row ->right
            for(int i=colBegin;i<=colEnd;i++){
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //traverse the right col
            for(int i=rowBegin;i<=rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            //traverse the bottom row
            if(rowBegin <= rowEnd){
                for(int i=colEnd;i>=colBegin;i--){
                list.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            }

            //traverse the left col
            if(colBegin <= colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                list.add(matrix[i][colBegin]);
            }
            colBegin++;
            }
        }
        return list;
    }
}