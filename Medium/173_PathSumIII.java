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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sum(root,sum,new ArrayList<>());
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();
    public void sum(TreeNode root,int sum,List<Integer> tempAns){
        if(root==null)
            return;
        if(sum-root.val==0){
            if(root.left==null && root.right==null){
                List<Integer> ret=new ArrayList<>(tempAns);
                ret.add(root.val);
                ans.add(ret);
                return ;
            }
        }
        tempAns.add(root.val);
        sum(root.left,sum-root.val,tempAns);
        sum(root.right,sum-root.val,tempAns);
        tempAns.remove(tempAns.size()-1);        
    }
}