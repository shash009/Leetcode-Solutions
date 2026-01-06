/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int res = 1;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int currSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode pop = q.poll();
                currSum += pop.val;
                if(pop.left != null){
                    q.offer(pop.left);
                }
                if(pop.right != null){
                    q.offer(pop.right);
                }
            }
            if(currSum > max){
                res = level;
                max = currSum;
            }
            level++;
        }
        return res;
    }
}