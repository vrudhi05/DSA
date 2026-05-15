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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){ //edgecase
            return list;
        }
        queue.add(root); //store the root
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode Root = queue.poll();
                level.add(Root.val);

                if(Root.left != null){
                    queue.add(Root.left);
                }
                if(Root.right != null){
                    queue.add(Root.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}