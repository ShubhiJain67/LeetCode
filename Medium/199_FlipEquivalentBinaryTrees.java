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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isSimilar(root1,root2);
    }
    public boolean isSimilar(TreeNode root1,TreeNode root2){
        if(root1==null){
            if(root2==null){
                return true;
            }
            return false;
        }
        if(root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return (isSimilar(root1.left,root2.left) && isSimilar(root1.right,root2.right)) || (isSimilar(root1.left,root2.right) && isSimilar(root1.right,root2.left));
    }
    
}