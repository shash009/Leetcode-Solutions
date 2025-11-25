class Solution {
    public void dfs(List<List<Integer>> rooms, int src, boolean[] vis){
        vis[src] = true;
        for(int i : rooms.get(src)){
            if(vis[i] == false)
            dfs(rooms, i, vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(rooms, 0, vis);
        for(var it: vis){
            if(it == false){
                return false;
            }
        }
        return true;
    }
}