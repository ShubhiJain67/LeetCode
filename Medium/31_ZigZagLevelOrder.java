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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null) return ans;
        int LtoR=1;
        q.add(root);
        q.add(null);
        while(q.size()!=0){
            TreeNode t=q.remove();
            if(LtoR==1){
            while(t!=null){
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
                temp.add(t.val);
                t=q.remove();
            }
                LtoR=0;
            }
            else{
            while(t!=null){
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
                temp.add(0,t.val);
                t=q.remove();
            }
                LtoR=1;
            }
            q.add(null);
            System.out.println(q.size());
            
            ans.add(temp);
            if(q.peek()==null)break;
            temp=new ArrayList<Integer>();
        }
        return ans;
    }
}