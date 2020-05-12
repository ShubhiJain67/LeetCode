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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        int levelMax=0;
        int sumMax=Integer.MIN_VALUE;
        queue.add(root);
        int level=1;
        while(queue.size()!=0){
            int size=queue.size();
            int sum=0;
            while(size-->0){
                TreeNode node=queue.removeFirst();
                sum+=node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            
            if(sum>sumMax){
                // System.out.println(sum+" "+level);
                sumMax=sum;
                levelMax=level;
            }
            level++;
        }
        return levelMax;
    }
}