class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        String ans = new String();
        int n  = s.length();
        int j = 0;
        int i = 0;
        for( j = 0; j < n; j++){
            while (j < n && !hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                j++;
            }
            if(j == n) break;
            if(ans.length() < j - i){
                ans = s.substring(i,j);
            }
            while ( i< n && s.charAt(i) != s.charAt(j)) {
                hs.remove(s.charAt(i));
                i++;
            }
            i++;
        }
        if(ans.length() < j-i+1){
            ans = s.substring(i,j);
        }
        return ans.length();
    }
}