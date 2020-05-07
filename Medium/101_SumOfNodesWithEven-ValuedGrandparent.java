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
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> grandParents=new LinkedList<>();
        LinkedList<TreeNode> parents=new LinkedList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=0;;
        while(queue.size()!=0){
            TreeNode node=queue.removeFirst();
            if((node.val&1)==0){
                grandParents.add(node);
                if(node.left!=null){
                    if(node.left.left!=null)
                        ans+=node.left.left.val;
                    if(node.left.right!=null)
                        ans+=node.left.right.val;                        
                }
                if(node.right!=null){
                    if(node.right.left!=null)
                        ans+=node.right.left.val;
                    if(node.right.right!=null)
                        ans+=node.right.right.val;
                }
                    
                
            }
            if(node.left!=null)
                queue.addLast(node.left);
            if(node.right!=null)
                queue.addLast(node.right);
        }        
        return ans;
    }
}