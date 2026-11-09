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
    int depth = 0;
    public void traverse(TreeNode node, int cnt){
        if(node == null){
            return;
        }
        depth = Math.max(depth,cnt);
        traverse(node.left,cnt+1);
        traverse(node.right,cnt+1);
    }
    public int maxDepth(TreeNode root) {
        traverse(root,1);
        return depth;
    }
}