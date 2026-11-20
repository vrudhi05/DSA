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
    public int leftDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int cnt=0;
        while(node != null){
            node = node.left;
            cnt++;
        }
        return cnt;
    }
    public int rightDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int cnt=0;
        while(node!= null){
            node = node.right;
            cnt++;
        }
        return cnt;
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left= leftDepth(root);
        int right = rightDepth(root);
        if(left == right){
            return (int)Math.pow(2,left)-1; //formula 2^h - 1
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}