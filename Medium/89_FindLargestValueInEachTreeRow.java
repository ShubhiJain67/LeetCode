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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        
        //--------------Array List which will have all the maxium elements------------------------
        ArrayList<Integer> ans=new ArrayList<Integer>();
        
       
        while(queue.size()!=0){
            int size=queue.size();
            //-----------------------To store the maxium value at each evel------------------------
            int levelMax=Integer.MIN_VALUE;
             //----------------------------To make a record of each level-----------------------------
            while(size-->0){
                TreeNode node=queue.removeFirst();
                
                //---checking is the value of this node greater than the ones which are alrady encountered---
                if(levelMax<node.val)
                    levelMax=node.val;
                
                //-----------------------Pushing the nodes which are on the next level--------------
                if(node.left!=null)  queue.addLast(node.left);
                if(node.right!=null)  queue.addLast(node.right);
            }
            ans.add(levelMax);
        }
        return ans;
    }
}

