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
    boolean ans = false;
    public boolean checkSum(TreeNode root, int sum,int targetSum, ArrayList<Integer> list){
        if(root == null){
            return false;
        }
        list.add(root.val);
        sum += root.val;

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                ans = true;
            }
        }
        else{
            checkSum(root.left,sum,targetSum,list);
            checkSum(root.right,sum,targetSum,list);
        }
        sum -= list.get((list.size()-1)); //update the sum
        list.remove(list.size()-1); //remove the last element from the list as well
        return ans;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        return checkSum(root,0,targetSum,list);
    }
}