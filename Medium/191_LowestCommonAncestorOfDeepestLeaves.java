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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root,getDepth(root),1);
    }
    private int getDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
    private TreeNode helper(TreeNode root,int depth,int currDepth){
        if(root==null)
            return null;
        if(currDepth==depth)
            return root;
        TreeNode left=helper(root.left,depth,currDepth+1);
        TreeNode right=helper(root.right,depth,currDepth+1);
        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;
    }
}
