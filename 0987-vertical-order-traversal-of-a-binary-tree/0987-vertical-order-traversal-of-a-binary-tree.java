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

    class Pair {

        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeMap<Integer,
                TreeMap<Integer, PriorityQueue<Integer>>> map
                = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

      
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair p = q.remove();

            TreeNode curr = p.node;
            int row = p.row;
            int col = p.col;

            
            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            
            map.get(col).get(row).add(curr.val);

            // left child
            if (curr.left != null) {
                q.add(new Pair(curr.left, row + 1, col - 1));
            }

            // right child
            if (curr.right != null) {
                q.add(new Pair(curr.right, row + 1, col + 1));
            }
        }

        // traverse columns
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            // traverse rows
            for (PriorityQueue<Integer> pq : rows.values()) {

                // sorted values
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}