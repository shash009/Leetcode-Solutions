class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> mpp = new HashMap<>();
        int ans = 0;
        for(int[] i : grid){
            String row = Arrays.toString(i);
            mpp.put(row, mpp.getOrDefault(row, 0) + 1);
        }
        for(int i = 0; i < n; i++){
            int[] col = new int[n];
            for(int j = 0; j < n; j++){
                col[j] = grid[j][i];
            }
            String s = Arrays.toString(col);
            if(mpp.containsKey(s)){
                ans = ans + mpp.get(s);
            }
        }
        return ans;
    }
}