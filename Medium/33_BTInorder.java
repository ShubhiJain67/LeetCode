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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        while (curr != null || s.size() > 0) 
        {
            while (curr !=  null) 
            { 
                s.push(curr); 
                curr = curr.left; 
            } 
            curr = s.pop(); 
  
           list.add(curr.val); 

            curr = curr.right; 
        }
        return list;
    }
}