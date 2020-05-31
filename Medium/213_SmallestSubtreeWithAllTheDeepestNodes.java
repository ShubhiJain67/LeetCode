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
    int height;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height=getHeight(root);
        return LCA(root,1);
    }
    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    private TreeNode LCA(TreeNode root,int h){
        if(root==null || h==height) return root;
        TreeNode l=LCA(root.left,h+1);
        TreeNode r=LCA(root.right,h+1);
        
        if(l!=null && r!=null)   return root;
        if(l!=null) return l;
        if(r!=null) return r;
        return null;
    }
    
}