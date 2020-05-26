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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        int left=findMaxLength(root.left);
        int right=findMaxLength(root.right);
        if(Math.abs(left-right)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int findMaxLength(TreeNode node){
        if(node==null) return 0;
        if(node.left==null && node.right==null) return 1;
        int leftlen=findMaxLength(node.left);
        int rightlen=findMaxLength(node.right);
        return leftlen>rightlen?leftlen+1:rightlen+1;
    }
}