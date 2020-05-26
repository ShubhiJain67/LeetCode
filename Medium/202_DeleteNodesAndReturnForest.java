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
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans=new ArrayList<>();
        ArrayList<Integer> delete=new ArrayList<>();
        for(int i: to_delete)
            delete.add(i);
        root=helper(root,delete);
        if(root!=null)
            ans.add(root);
        return ans;
    }
    public TreeNode helper(TreeNode root,ArrayList<Integer> delete){
        if(root==null)
            return null;
        root.left=helper(root.left,delete);
        root.right=helper(root.right,delete);
        if(delete.indexOf(root.val)!=-1){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}