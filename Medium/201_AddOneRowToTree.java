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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1) return new TreeNode(v,root,null);
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=2;
        while(count<d){
            int size=queue.size();
            while(size-->0){
                TreeNode node=queue.removeFirst();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            count++;
        }
        while(queue.size()!=0){
            TreeNode node=queue.removeFirst();
            node.left=new TreeNode(v,node.left,null);
            node.right=new TreeNode(v,null,node.right);
        }
        return root;
    }
}