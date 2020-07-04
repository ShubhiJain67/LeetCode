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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left=0;
        int right=0;
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
           return minDepth(root.left)+1;
        }
        left=minDepth(root.left);
        right=minDepth(root.right);
        return (left<right?left:right)+1;
    }
}