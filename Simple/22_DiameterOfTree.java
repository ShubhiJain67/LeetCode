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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int diaOfroot=Diameter(root);
        int leftChildDia=0,rightChildDia=0;
        if(root.left!=null)
            leftChildDia=diameterOfBinaryTree(root.left);
        if(root.right!=null)
            rightChildDia=diameterOfBinaryTree(root.right);
        
        if(diaOfroot>leftChildDia && diaOfroot>rightChildDia)
            return diaOfroot;
        if(leftChildDia<rightChildDia)
            return rightChildDia;
        else
            return leftChildDia;
    }
    public int Diameter(TreeNode root){
        if(root==null) return 0;
        int left=0;
        int right=0;
        if(root.left!=null){
            left=MaxHeight(root.left);
        }
        if(root.right!=null){
            right=MaxHeight(root.right);
        }
        return left+right;
    }
    public int MaxHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left=MaxHeight(root.left);
        int right=MaxHeight(root.right);
        if(left>right)
            return left+1;
        return right+1;
    }
}