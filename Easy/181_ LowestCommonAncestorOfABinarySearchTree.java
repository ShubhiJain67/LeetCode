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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null || q==null) return null;
        while(root!=null){
            if(root.val==p.val || root.val==q.val)
                return root;
            else if(root.val>p.val && root.val>q.val)
                root=root.left;
            else if(root.val<p.val && root.val<q.val)
                root=root.right;
            else
                return root;
        }
        return null;
    }
}