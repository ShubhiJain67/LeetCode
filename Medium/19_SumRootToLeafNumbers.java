/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    void pathSum(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        sol.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer>(sol));
        } else {
            pathSum(root.left, sum - root.val, sol, res);
            pathSum(root.right, sum - root.val, sol, res);
        }
        
        sol.remove(sol.size() - 1);
    }
}