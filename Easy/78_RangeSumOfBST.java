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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.push(root);
        int sum=0;
        int n=queue.size();
        while(n!=0){
            TreeNode node=queue.removeFirst();
            n--;
            int val=node.val;
            if(val>=L && val<=R)   
                sum+=val;
            if(node.left!=null){
                queue.addLast(node.left);
                n++;
            }
            if(node.right!=null){
                queue.addLast(node.right);
                n++;
            }
        }
        return sum;
    }
}