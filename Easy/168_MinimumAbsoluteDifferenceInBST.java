/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        list=new ArrayList<>();
        fillList(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            // System.out.print(list.get(i)+" ");
            int diff=list.get(i)-list.get(i-1);
            if(min>diff)
                min=diff;
        }
        return min;
    }
    private void fillList(TreeNode root){
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        if(root.left!=null)
            fillList(root.left);
        list.add(root.val);
        if(root.right!=null)
            fillList(root.right);
    }
    
}