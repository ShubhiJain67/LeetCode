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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null) return list;
        q.add(root);
        q.add(null);
        while(q.size()!=0){
            TreeNode t=q.remove();
            while(t!=null){
                if(t.left!=null)
                q.add(t.left);
                if(t.right!=null)
                q.add(t.right);
                temp.add(t.val);
                t=q.remove();
            }
            q.add(null);
            list.add(temp);
            if(q.peek()==null)break;
            System.out.println(temp);
            temp=new ArrayList<Integer>();
            System.out.println(q.size());
        }
        return list;
    }
}