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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
       if(root ==null || root.left == null && root.right == null){
            return root;
        }
        int h = findH(root);
        return findAns(root,h);
    }

    TreeNode findAns(TreeNode root ,int h){
        if(h==1 || root == null){
            return root;
        }
        TreeNode left = findAns(root.left,h-1);
        TreeNode right = findAns(root.right,h-1);
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }
        return left;
    }

    int findH(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = findH(root.left);
        int r = findH(root.right);
        if(l>=r){
            return l+1;
        }
        return r+1;
    }
}