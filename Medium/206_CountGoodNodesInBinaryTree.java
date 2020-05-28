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
    int count=1;
    public int goodNodes(TreeNode root) {
        traverse(root.left,root.val);
        traverse(root.right,root.val);
        return count;
    }
    public void traverse(TreeNode root,int maxSoFar){
        if(root==null)
            return;
        if(root.val>=maxSoFar)
            count++;
        traverse(root.left,maxSoFar>root.val?maxSoFar:root.val);
        traverse(root.right,maxSoFar>root.val?maxSoFar:root.val);
    }
}