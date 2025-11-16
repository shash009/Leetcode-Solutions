class Solution {
    static String s;
    static long [][][] dp;

    public long helper(int i, int t, int st){
        if(i == s.length()){
            return 1;
        }
        if(dp[i][t][st] != -1){
            return dp[i][t][st];
        }
        long res = 0;
        int up = t == 1? s.charAt(i) - '0' : 9;
        for(int d = 0; d<= up; d++){
            if(d == 0 && st == 1){
                continue;
            }
            int j = (t == 1 && d == up) ? 1 : 0;
            int k = (d == 0 && st == 0) ? 0 : 1;
            res += helper(i + 1, j, k);
        }
        return dp[i][t][st] = res;
    }
    public long countDistinct(long n) {
        s = Long.toString(n);
        dp = new long[s.length()][2][2];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        long ans = helper(0, 1, 0);
        return ans - 1;
    }
}