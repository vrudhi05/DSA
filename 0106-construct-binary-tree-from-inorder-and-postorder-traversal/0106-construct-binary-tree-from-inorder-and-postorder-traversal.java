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
    public int find(int[] inorder, int target, int start, int end){
        for(int i=start;i<=end;i++){
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
    public TreeNode construct(int[] inorder,int[] postorder, int inStart, int inEnd,int index){
        if(inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int pos = find(inorder,root.val,inStart,inEnd);
        root.right = construct(inorder,postorder,pos+1,inEnd,index-1);
        root.left = construct(inorder,postorder,inStart,pos-1,(index-(inEnd-pos))-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return construct(inorder,postorder,0,postorder.length-1,postorder.length-1);
    }
}