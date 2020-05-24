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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trim(root,L,R);
    }
    private TreeNode trim(TreeNode root,int L,int R){
        if(root==null)
            return null;
        root.left=trim(root.left,L,R);
        root.right=trim(root.right,L,R);
        if(root.val<L || root.val>R){
            if(root.left==null && root.right==null)
                root=null;
            else if(root.left==null)
                root=root.right;
            else
                root=root.left;
        }
        return root;
    }
}