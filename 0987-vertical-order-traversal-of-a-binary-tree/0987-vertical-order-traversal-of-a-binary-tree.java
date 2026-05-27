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

    TreeMap<Integer,  //columns
    TreeMap<Integer,PriorityQueue<Integer>>> mp;   //rows -> PriorityQueue

    public void dfs(TreeNode root, int row, int col){
        if(root == null){
            return;
        }

        //create the column if absent
        if(!mp.containsKey(col)){
            mp.put(col, new TreeMap<>());
        }

        //create the row if absent
        if(!mp.get(col).containsKey(row)){
            mp.get(col).put(row,new PriorityQueue<>());
        }

        mp.get(col).get(row).offer(root.val);  //insert the node's value

        //go towards the left
        dfs(root.left,row+1,col-1);

        //go towards the right
        dfs(root.right,row+1,col+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        mp = new TreeMap<>();

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans; //base case
        }

        dfs(root,0,0);

        for(TreeMap<Integer,PriorityQueue<Integer>> rows : mp.values()){  //traverse the columns
            List<Integer> subList = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()){  //traverse the rows
                while(!pq.isEmpty()){  //pop until pq is empty
                    subList.add(pq.poll());
                }
            }
            ans.add(subList);
        }
        return ans;
    }
}