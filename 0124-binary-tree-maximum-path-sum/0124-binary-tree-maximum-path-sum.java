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
    int maxSum = Integer.MIN_VALUE;
    public int pathsum(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = pathsum(node.left);
        int right = pathsum(node.right);

        int all_good = node.val+left+right; //1
        int both_good = node.val+Math.max(left,right); //2
        int only_one_good = node.val; //3

        maxSum = Math.max(maxSum,Math.max(all_good,
        Math.max(both_good,only_one_good)));
        return Math.max(both_good,only_one_good);
    }
    public int maxPathSum(TreeNode root) {
        pathsum(root);
        return maxSum;
    }
}