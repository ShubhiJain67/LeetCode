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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)  return ans;
        List<TreeNode> parent=new ArrayList<>();
        parent.add(root);
        while(parent.size()!=0){
            int size=parent.size();
            List<TreeNode> child=new ArrayList<>();
            int index=-1;
            while(++index!=size){
                TreeNode node=parent.get(index);
                if(node.left!=null) child.add(node.left);
                if(node.right!=null)    child.add(node.right);
            }
            List<Integer> temp=new ArrayList<>();
            for(TreeNode n:parent)  temp.add(n==null?null:n.val);
            ans.add(0,temp);
            parent=child;
        }
        return ans;
    }
}