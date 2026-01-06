class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0 && nums.length == 1) return true;
        if(nums[0] == 0 && nums.length >= 1) return false;
        if(nums[0] >= nums.length) return true;
        int maxdist = nums[0];

        for(int i = 0; i < nums.length; i++){
            int curr = i + nums[i];
            maxdist = Math.max(maxdist, curr);
            if(maxdist >= nums.length - 1){
                return true;
            }
            if(nums[maxdist] == 0 && i == maxdist){
                return false;
            }
        }
        return false;
    }
}