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
    public int find(int[] inorder,int target,int start, int end){
        for(int i=start;i<=end;i++){
            if(inorder[i] == target){
                return i;
            }
        }
        return -1;
    }
    public TreeNode construct(int[] inorder, int[] preorder, int inStart, int inEnd,int index){
        if(inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = find(inorder,preorder[index],inStart,inEnd);
        root.left = construct(inorder,preorder,inStart, pos-1,index+1);
        root.right = construct(inorder,preorder,pos+1,inEnd,index+(pos-inStart)+1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(inorder,preorder,0,inorder.length-1,0);
    }
}