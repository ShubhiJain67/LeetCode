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
    public String smallestFromLeaf(TreeNode root) {
        traverse(root,"");
        return str;
    }
    String str="";
    private void traverse(TreeNode root,String curr){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            String s=(char)(root.val+97)+curr;
            // System.out.println(s);
            if(str.compareTo("")==0 || str.compareTo(s)>0){
                str=s;
            }
            return;
        }
        traverse(root.left,(char)(root.val+97)+curr);
        traverse(root.right,(char)(root.val+97)+curr);
    }
    
}