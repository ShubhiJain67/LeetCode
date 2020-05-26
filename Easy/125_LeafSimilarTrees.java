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
    ArrayList<Integer> first=new ArrayList<>();
    ArrayList<Integer> second=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        DFS1(root1);
        DFS2(root2);
        if(first.size()!=second.size()) return false;
        for(int i=0;i<first.size();i++){
            if(first.get(i)!=second.get(i))
                return false;
        }
        return true;
    }
    public void DFS1(TreeNode root1){
        if(root1==null) return;
        if(root1.left==null && root1.right==null){
            first.add(root1.val);
        }
        DFS1(root1.left);
        DFS1(root1.right);
    }
    public void DFS2(TreeNode root2){
        if(root2==null) return;
        if(root2.left==null && root2.right==null){
            second.add(root2.val);
        }
        DFS2(root2.left);
        DFS2(root2.right);
    }
}