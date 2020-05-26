/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList <Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list=new ArrayList();
        inorder(root);
        for(int i=0;i<list.size();i++){
            int n=list.get(i);
            if(list.indexOf(k-n)!=-1 && list.indexOf(k-n)!=i)
                return true;
        }
        return false;
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}