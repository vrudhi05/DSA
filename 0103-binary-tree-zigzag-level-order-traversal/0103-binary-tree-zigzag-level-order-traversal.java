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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int cnt = 1;

        while(!q.isEmpty()){
            int size1 = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<size1;i++){
                TreeNode temp = q.remove();
                if(cnt % 2 == 0){
                    subList.add(0,temp.val);
                }
                else{
                    subList.add(temp.val);
                }
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            cnt += 1;
            list.add(subList);
        }
        return list;
    }
}