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
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> levelUp=new LinkedList<>();
        LinkedList<TreeNode> levelDown=new LinkedList<>();
        levelUp.add(root);
        outer:
        while(levelUp.size()!=0){
            int size=levelUp.size();
            int i=0;
            while(i!=size){
                TreeNode node=levelUp.get(i++);
                if(node.left!=null)
                    levelDown.addLast(node.left);
                if(node.right!=null)
                    levelDown.addLast(node.right);
            }
            if(levelDown.size()==0)
                break outer;
            levelUp=levelDown;
            levelDown=new LinkedList<>();
        }
        int sum=0;
        while(levelUp.size()!=0){
            TreeNode node=levelUp.removeFirst();
            sum=sum+node.val;
        }
        return sum;
    }
}