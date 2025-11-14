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
    int ans;
    public void helper(TreeNode root, boolean isleft, int len){
        if(root == null){
            return;
        }
        ans = Math.max(ans, len);
        if(isleft){
            helper(root.right, false, len + 1);
            helper(root.left, true, 1);
        }else{
            helper(root.left, true, len + 1);
            helper(root.right, false, 1);
        }
    }
    public int longestZigZag(TreeNode root) {
        ans = 0;
        helper(root.left, true, 1);
        helper(root.right, false, 1);
        return ans;
    }
}