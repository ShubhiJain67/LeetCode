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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre,post,0,pre.length-1,0,post.length-1);
    }
    public TreeNode construct(int[] pre, int[] post,int i1,int j1,int i2,int j2) {
        if(j1-i1+1<=0)
            return null;
        TreeNode node=new TreeNode(pre[i1]);
        if(j1-i1+1==1)
            return node;
        int index=getIndex(post,i2,j2,pre[i1+1]);
        int len=index-i2+1;
        node.left=construct(pre,post,i1+1,i1+len,i2,i2+len);
        node.right=construct(pre,post,i1+len+1,j1,index+1,j2);
        return node;
    }
    private int getIndex(int [] post,int s,int e,int num){
        while(s<=e){
            if(post[s++]==num)
                return s-1;
        }
        return -1;
    }
}