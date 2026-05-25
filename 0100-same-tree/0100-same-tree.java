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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        que1.add(p);
        que2.add(q);

        while(!que1.isEmpty() && !que2.isEmpty()){
            TreeNode node1 = que1.remove();
            TreeNode node2 = que2.remove();

            if(node1.val != node2.val){
                return false;
            }
            if(node1.left != null && node2.left != null){ //both exists
                que1.add(node1.left);
                que2.add(node2.left);
            }
            else if(node1.left != null || node2.left != null){ //either exists
                return false;
            }

            if(node1.right != null && node2.right != null){
                que1.add(node1.right);
                que2.add(node2.right);
            }
            else if(node1.right != null || node2.right != null){
                return false;
            }
        }
        return true;
    }
}