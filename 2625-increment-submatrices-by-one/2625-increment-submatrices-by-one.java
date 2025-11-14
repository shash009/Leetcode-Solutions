class Solution {
    public void addOne(int n, int startrow, int startcol, int endrow, int endcol, int[][] res){
        for(int i = startrow; i <= endrow; i++){
            for(int j = startcol; j <= endcol; j++){
                res[i][j] += 1;
            }
        }
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for(int[] i: queries){
            int startrow = i[0];
            int startcol = i[1];
            int endrow = i[2];
            int endcol = i[3];
            addOne(n, startrow, startcol, endrow, endcol, res);
        }
        return res;
    }
}