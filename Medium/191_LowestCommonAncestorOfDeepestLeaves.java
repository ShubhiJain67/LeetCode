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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return root;
        LinkedList<TreeNode> q1=new LinkedList<>();
        LinkedList<TreeNode> lastLevel=new LinkedList<>();
        q1.add(root);
        lastLevel=new LinkedList<>(q1);
        while(q1.size()!=0){
            int size=q1.size();
            while(size-->0){
                TreeNode node=q1.removeFirst();
                if(node.left!=null)
                    q1.addLast(node.left);
                if(node.right!=null)
                    q1.addLast(node.right);
            }
            if(q1.size()!=0)
                lastLevel=new LinkedList<>(q1);
        }
        TreeNode ans;
        if(lastLevel.size()==1)
            ans=lastLevel.removeFirst();
        else{
            TreeNode node1=lastLevel.removeFirst();
            TreeNode node2 = lastLevel.removeFirst();
            ans=GetAn(node1,node2,root);
            while(lastLevel.size()!=0)
                ans=GetAn(ans,lastLevel.removeFirst(),root);
        }
        return ans;
    }
    private TreeNode GetAn(TreeNode node1,TreeNode node2,TreeNode root){
        if(root==null || root==node1 || root==node2){
            return root;
        }
        TreeNode left=GetAn(node1,node2,root.left);
        TreeNode right=GetAn(node1,node2,root.right);
        if(left==null && right==null)
            return null;
        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;
    }
}