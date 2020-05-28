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
    HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        traverse(root);
        int max=0;
        int count=0;
        for(Integer k:map.keySet()){
            if(map.get(k)>max){
                max=map.get(k);
                count=1;
            }
            else if(map.get(k)==max){
                count++;
            }
        }
        int ans[]=new int[count];
        
        for(Integer k:map.keySet()){
            if(map.get(k)==max)
                ans[--count]=k;
        }
        return ans;
    }
    private void traverse(TreeNode root){
        if(root==null)
            return;
        traverse(root.left);
        traverse(root.right);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
    }
}