class Solution {
    public int[] countDivisor(int n){
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;
        int curr = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                arr[0]++; 
                arr[1] += i;
            }
            if(arr[0] > 4){
                return arr;
            }
        } 
        return arr;
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int[] curr = countDivisor(nums[i]);
            if(curr[0] == 4){
                ans += curr[1];
            }
        }
        return ans;
    }
}