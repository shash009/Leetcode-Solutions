class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);  
        int ans = 0;
        for (int i : nums) {
            while (!stk.isEmpty() && stk.peek() > i) {
                stk.pop();
                ans++;
            }
            if (stk.isEmpty() || stk.peek() != i) {
                stk.push(i);
            }
        }
        return ans + stk.size() - 1; 
    }
}