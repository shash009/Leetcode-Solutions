class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder ans = new StringBuilder();
        int[] arr = new int[s.length()];
        int row = 1;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {
            arr[i] = row;
            if (row == numRows) {
                goingDown = false;
            } else if (row == 1) {
                goingDown = true;
            }
            row += goingDown ? 1 : -1;
        }
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < s.length(); j++){
                if(arr[j] == i+1){
                    ans.append(s.charAt(j));
                }
            }
        }
        return ans.toString();
    }
}