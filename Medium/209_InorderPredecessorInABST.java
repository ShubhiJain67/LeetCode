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
    TreeNode pre;
    TreeNode prev;
    TreeNode succ;
    boolean prefound;
    public TreeNode Predecessor(TreeNode root,TreeNode n) {
        prefound=false;
        pre=null;
        prev=null;
        succ=null;
        traverse(root,n);
        return pre;
    }
    private void traverse(TreeNode root,TreeNode n){
        if(root==null )
            return;
        if(pre==n){
            prefound=true;
        }
        if(prev==n){
            return;
        }
        traverse(root.left,n);
        if(!prefound)
            pre=root;
        prev=succ;
        succ=root;
        if(root.right!=null)
            traverse(root.right,n);
    }
}