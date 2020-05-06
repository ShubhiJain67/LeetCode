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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l=preorder.length-1;
        return build(preorder,0,l,inorder,0,l);
    }
    public TreeNode build(int[] preorder,int pi,int pj, int[] inorder,int ii,int ij){
        if(ii>ij || pi>pj) return null;
        TreeNode root=new TreeNode(preorder[pi]);
        int indexInInorder=find(preorder[pi],inorder);
        root.left=build(preorder,pi+1,pi+indexInInorder-ii,inorder,ii,indexInInorder-1);
        root.right=build(preorder,pi+indexInInorder-ii+1,pj,inorder,indexInInorder+1,ij);
        return root;
    }
    public int find(int num,int inorder[]){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==num) return i;
        }
        return -1;
    }
}