class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'R'){
                left--;
            }else{
                left++;
            }
        }
        int right = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L'){
                right--;
            }else{
                right++;
            }
        }
        return Math.max(left, right);
    }
}