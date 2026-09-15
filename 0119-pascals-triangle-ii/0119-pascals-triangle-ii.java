class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[rowIndex+1][rowIndex+1];

        for(int i=0;i<=rowIndex;i++){
            List<Integer> list2 = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i == j || j == 0){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                list2.add(arr[i][j]);
            }
            list.add(list2);
        }
        return list.get(rowIndex);
    }
}