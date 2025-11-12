class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int one = 0;
        for (int num : nums) {
            if (num == 1) {
                one++;
            }
        }
        if (one > 0){
            return n - one;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currGcd = gcd(currGcd, nums[j]);
                if (currGcd == 1) {
                    min = Math.min(min, j - i);
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        return min + n - 1;
    }
}