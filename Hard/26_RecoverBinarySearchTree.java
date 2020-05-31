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
    TreeNode a=null;
    TreeNode b=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        recover(root);
        if(a!=null){
            int temp=a.val;
            a.val=b.val;
            b.val=temp;
        }
    }
    private boolean recover(TreeNode root){
        if(root==null)
            return false;
        if(recover(root.left))
            return true;
        if(prev!=null && prev.val>root.val){
            b=root;
            if(a==null)
                a=prev;
            else
                return true;
        }
        prev=root;
        if(recover(root.right))
            return true;
        return false;
        
    }
}