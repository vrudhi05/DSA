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
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);

        int check_if_this_is_max = left + right + root.val;
        int check_if_only_one = Math.max(left,right) + root.val;
        int if_only_root = root.val;
        result = Math.max(
            result,
            Math.max(
                check_if_this_is_max,
                Math.max(check_if_only_one, if_only_root)
            )
        );
        return Math.max(check_if_only_one , if_only_root);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        solve(root);
        return result;
    }
}