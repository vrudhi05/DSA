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
    public void nodeParentMapping(TreeNode node, Map<TreeNode , TreeNode> map){
        if(node == null){
            return;
        }
        if(node.left != null){
            map.put(node.left,node);
            nodeParentMapping(node.left,map);
        }
        if(node.right != null){
            map.put(node.right,node);
            nodeParentMapping(node.right,map);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>(); //to store node --> parent
        nodeParentMapping(root,map);

        Queue<TreeNode> q = new LinkedList<>();  //to store current level's node
        q.offer(target);

        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);

        int distance = 0;

        while(!q.isEmpty() && distance < k){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node.left != null && !set.contains(node.left)){
                    q.offer(node.left);
                    set.add(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    q.offer(node.right);
                    set.add(node.right);
                }
                TreeNode par = map.get(node);
                if(par != null && !set.contains(par)){
                    q.offer(par);
                    set.add(par);
                }
            }
            distance++;
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}