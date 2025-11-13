class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) ->  a[1] - b[1]);
        int cnt = 0;
        int prev = nums[0][1];
        for(int i = 1; i < nums.length; i++){
            if(prev > nums[i][0]){
                cnt++;
            }else{
                prev = nums[i][1];
            }
        }
        return cnt;
    }
}