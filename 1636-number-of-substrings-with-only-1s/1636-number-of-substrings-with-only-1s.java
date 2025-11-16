class Solution {
    final int MOD = 1000000007;
    public int numSub(String s) {
        long count = 0;
        long ones = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ones++;
            }else{
                count += (ones * (ones + 1) / 2) % MOD;
                ones = 0;
            }
        }
        count = (count + ones * (ones + 1) / 2) % MOD;
        return (int)count;
    }
}