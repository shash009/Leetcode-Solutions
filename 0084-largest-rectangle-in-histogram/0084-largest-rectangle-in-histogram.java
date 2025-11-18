class Solution {

    public void findnextsmaller(int[] nums, int[] nse, int n){
        Stack<Integer> stk = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = stk.peek();
            }
            stk.push(i);
        }
    }

    public void findprevioussmaller(int[] nums, int[] pse, int n){
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = stk.peek();
            }
            stk.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        findnextsmaller(heights, nse, n);
        findprevioussmaller(heights, pse, n);
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            max = Math.max(max, (heights[i] * (nse[i] - pse[i] - 1)));
        }
        
        return max;
    }
}