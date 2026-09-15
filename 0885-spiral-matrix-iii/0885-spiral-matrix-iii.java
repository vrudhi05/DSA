class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows*cols][2];
        int r = rStart;
        int c = cStart;
        int steps = 1;
        int count = 0;
        ans[count++] = new int[]{r, c};

        while(count < rows*cols){

            //RIGHT
            for(int i=0;i<steps;i++){
                c++;
                if(r >=0 && r < rows && c >= 0 && c < cols){
                    ans[count++] = new int[]{r,c};
                }
            }

            //DOWN
            for(int i=0;i<steps;i++){
                r++;
                if(r >=0 && r < rows && c >= 0 && c < cols){
                    ans[count++] = new int[]{r,c};
                }
            }

            steps++;

            //LEFT
            for(int i=0;i<steps;i++){
                c--;
                if(r >=0 && r < rows && c >= 0 && c < cols){
                    ans[count++] = new int[]{r,c};
                }
            }

            //UP
            for(int i=0;i<steps;i++){
                r--;
                if(r >=0 && r < rows && c >= 0 && c < cols){
                    ans[count++] = new int[]{r,c};
                }
            }
            steps++;
        }
        return ans;
    }
}