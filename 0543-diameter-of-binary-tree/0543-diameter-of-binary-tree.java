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
    int result = Integer.MIN_VALUE;

    public int len(TreeNode root){
        if(root == null){ //edge case
            return 0;
        }

        int lh = len(root.left); //go left
        int rh = len(root.right); //go right
        result = Math.max(result,lh+rh); //calculate the diameter
        return 1+Math.max(lh,rh); //return the height
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        len(root);
        return result;
    }
}