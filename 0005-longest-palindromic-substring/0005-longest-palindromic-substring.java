class Solution {
    static int start = 0; 
    static int maxLen = 0;
    static void expand(String s, int i, int j) {
        while (j < s.length() && i > -1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }

    public String longestPalindrome(String s) {
        start = 0;
        maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start + maxLen);
    }
}