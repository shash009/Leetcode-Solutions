class Solution {
    public int dfs( List<List<Integer>> adj, int src, boolean[] vis){
        int ans = 0;
        vis[src] = true;
        for(int i : adj.get(src)){
            if(vis[Math.abs(i)] == false){
                if(i > 0){
                    ans++;
                }
                ans += dfs(adj, Math.abs(i), vis);
            }
        }
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: connections){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(-u);
        }
        return dfs(adj, 0, vis);
    }
}