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
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return -1;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        
        int ans=root.val;
        
        while(queue.size()!=0){
            int size=queue.size();
            //----------flag to see if the first element of the level is encountered or not--------
            boolean flag=false;
            
            while(size-->0){
                TreeNode node=queue.removeFirst();
                
                //-------------------------if the node is leaf node or not--------------------------
                if(node.left==null && node.right==null){
                    
                    //-----------if the node is the first leaf node of the current level------------
                    if(flag==false){
                        ans=node.val;
                        flag=true;
                    }
                }
                
                //-----------------------Pushing the nodes which are on the next level--------------
                if(node.left!=null)  queue.addLast(node.left);
                if(node.right!=null)  queue.addLast(node.right);
            }
        }
        return ans;
    }
}