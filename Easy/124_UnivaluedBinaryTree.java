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
    public boolean isUnivalTree(TreeNode root) {
       if(root==null) return true;
        int num=root.val;
        return isUniValued(root.right,num) && isUniValued(root.left,num);
    }
    public boolean isUniValued(TreeNode node,int num){
        if(node==null) return true;
        if(node.val==num)
            return isUniValued(node.right,num) && isUniValued(node.left,num);
        return false;     
    }
}