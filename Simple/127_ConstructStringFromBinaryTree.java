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
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        String ans=t.val+"";
        String left=tree2str(t.left);
        String right=tree2str(t.right);
        if(left.length()==0){
            if(right.length()!=0)
                ans=ans+"()("+right+")";
        }
        else{
            ans=ans+"("+left+")";
            if(right.length()!=0)
                ans=ans+"("+right+")";
        }
        return ans;
    }
}