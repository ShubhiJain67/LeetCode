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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        int i=0;
        while (i!=k &&(curr != null || s.size() > 0) )
        {
            while (curr !=  null) 
            { 
                s.push(curr); 
                curr = curr.left; 
            } 
            curr = s.pop(); 
            
           list.add(curr.val); 
            i++;
            curr = curr.right; 
        }
        return list.get(k-1);
        
    }
}