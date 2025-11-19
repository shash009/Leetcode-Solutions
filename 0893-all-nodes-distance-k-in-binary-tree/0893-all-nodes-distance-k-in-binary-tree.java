/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void addParent(TreeNode root, HashMap<TreeNode, TreeNode> mpp){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode pop = q.poll();
                if(pop.left != null){
                    mpp.put(pop.left, pop);
                    q.offer(pop.left);
                }
                if(pop.right != null){
                    mpp.put(pop.right, pop);
                    q.offer(pop.right);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        addParent(root, mpp);
        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int distance = 0;
        vis.put(target, true);
        while(!q.isEmpty()){
            if(distance == k){
                break;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode pop = q.poll();
                if(pop.left != null && vis.get(pop.left) == null){
                    q.offer(pop.left);
                    vis.put(pop.left, true);
                }
                if(pop.right != null && vis.get(pop.right) == null){
                    q.offer(pop.right);
                    vis.put(pop.right, true);
                }
                if(mpp.get(pop) != null && vis.get(mpp.get(pop)) == null){
                    q.offer(mpp.get(pop));
                    vis.put(mpp.get(pop), true);
                }
            }
            distance++;
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.peek().val);
            q.poll();
        }
        return res;
    }
}