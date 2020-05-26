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
    public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        int s=fill(root);
        int max=0;
        int count=0;
        for(Integer k:map.keySet()){
            int v=map.get(k);
            if(max<v){
                count=1;
                max=v;
            }else if(max==v)
                count++;
        }
        int[] ans=new int[count];
        for(Integer k:map.keySet()){
            if(map.get(k)==max){
                ans[--count]=k;
            }
        }
        return ans;
    }
    public int fill(TreeNode root){
        if(root==null)
            return 0;
        int left=0,right=0;
        if(root.left!=null)
            left=fill(root.left);
        if(root.right!=null)
            right=fill(root.right);
        int sum=left+right+root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}