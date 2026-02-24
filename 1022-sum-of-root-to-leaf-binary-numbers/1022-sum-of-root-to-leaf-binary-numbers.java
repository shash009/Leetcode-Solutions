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
    public void path(TreeNode root, List<String> list, StringBuilder s){
        if(root == null){
            return;
        }
        s.append(root.val);
        if(root.left == null && root.right == null){
            list.add(s.toString());
        }else{
            path(root.left, list, s);
            path(root.right,list, s);
        }
        s.setLength(s.length() - 1);
    }
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        path(root, list, s);
        int sum = 0;
        for(String i: list){
            sum += Integer.parseInt(i, 2);
        }
        return sum;
    }
}