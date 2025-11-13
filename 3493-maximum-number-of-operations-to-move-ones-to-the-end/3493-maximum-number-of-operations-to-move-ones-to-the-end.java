class Solution {
    public int maxOperations(String s) {
        int cnt = 0;
        int one = 0;
        int i = 0;
        for(; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                one++;
            }else if(i > 0 && s.charAt(i - 1) == '1'){
                cnt += one;
            }
        }
        return cnt;
    }
}