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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode n = queue.getFirst();
            res.add(n.val);
            
            int size = queue.size();
            while(size-->0) {
                TreeNode node = queue.removeFirst();
                if (node.right != null) {
                    queue.add(node.right);
                } 
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        
        return res;
    }
}
