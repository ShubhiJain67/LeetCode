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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        GetHeight(root);
        return max-1;
    }
    int max=0;
    
    public int GetHeight(TreeNode node){
        if(node==null)
            return 0;
        int left=GetHeight(node.left);
        int right=GetHeight(node.right);
        if(max<left+right+1)
            max=left+right+1;
        return Math.max(left,right)+1;
    }
}
