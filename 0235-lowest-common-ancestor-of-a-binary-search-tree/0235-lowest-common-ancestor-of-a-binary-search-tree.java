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
    TreeNode ans = null;
    public int find(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return 0;
        }
        int left = find(node.left,p,q);
        int right = find(node.right,p,q);
        int self = 0;
        if(node == p || node == q){
            self = 1;
        }
        int total = left+right+self;
        if((ans == null) && (total == 2)){
            ans = node;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root,p,q);
        return ans;
    }
}