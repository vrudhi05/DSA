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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        int maxWidth=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            Pair temp = queue.peek();
            int front = temp.idx;
            int rear = front;
            for(int i=0;i<size;i++){
                Pair curr = queue.remove();
                rear = curr.idx;
                if(curr.node.left != null){
                    queue.offer(new Pair(curr.node.left,2*curr.idx+1));
                }
                if(curr.node.right != null){
                    queue.offer(new Pair(curr.node.right,2*curr.idx+2));
                }
            }
            maxWidth = Math.max(maxWidth,rear-front+1);
        }
        return maxWidth;
    }
}