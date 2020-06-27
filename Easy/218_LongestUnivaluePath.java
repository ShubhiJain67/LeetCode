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
    public int longestUnivaluePath(TreeNode root) {
        traverse(root);
        return max;
    }
    int max=0;
    private int traverse(TreeNode root){
        if(root==null)
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        int l=0,r=0;
        if(root.left!=null && root.val==root.left.val){
            l=left+1;
        }
        if(root.right!=null && root.val==root.right.val){
            r=right+1;
        }
        max=Math.max(max,l+r);
        return Math.max(l,r);
    }
}