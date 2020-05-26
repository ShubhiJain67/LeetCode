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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val==key){
           root = delete(root,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            root.left=deleteNode(root.left,key);
        }
        return root;
    }
    private TreeNode delete(TreeNode root,int key){
        if(root.left==null && root.right==null)
            return null;
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        TreeNode helper=root.right;
        while(helper.left!=null)
            helper=helper.left;
        helper.left=root.left;
        return root.right;
    }
}