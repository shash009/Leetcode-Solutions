class Solution {
    int m;
    int n;
    int[][] dir = {{0, -1},{0, 1},{-1, 0},{1, 0}};
    public boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] vis){
        vis[r][c] = true;
        for(int[] d: dir){
            int cr = r + d[0];
            int cc = c + d[1];
            if(cr >= 0 && cr < m && cc >= 0 && cc < n){
                if (grid[cr][cc] != grid[r][c]){
                    continue;
                } 
                if(cr == pr && cc == pc){
                    continue;
                }
                if(vis[cr][cc] == true){
                    return true;
                }
                if(dfs(cr, cc, r, c, grid, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && dfs(i, j, -1, -1, grid, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}