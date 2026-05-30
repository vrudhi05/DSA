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

    public void checkSum(TreeNode root, int sum,int targetSum, List<Integer> subList, List<List<Integer>> list){
        if(root == null){
            return;
        }
        subList.add(root.val);
        sum += root.val;

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                list.add(new ArrayList<>(subList)); //create a new list(sublist) inside the final list
            }
        }
        else{
            checkSum(root.left,sum,targetSum,subList,list);
            checkSum(root.right,sum,targetSum,subList,list);
        }
        sum -= subList.get((subList.size()-1)); //update the sum
        subList.remove(subList.size()-1); //remove the last element from the list as well
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        checkSum(root,0,targetSum,subList,list);
        return list;
    }
}