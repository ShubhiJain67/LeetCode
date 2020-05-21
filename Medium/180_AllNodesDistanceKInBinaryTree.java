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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<TreeNode> rootToNodePath=getRootToNode(root,target);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<rootToNodePath.size();i++){
            if(K-i>=0){
                ans.addAll(BFS(rootToNodePath.get(i),rootToNodePath,K-i));
            }
        }
        return ans;
    }
    
    public List<Integer> BFS(TreeNode root,ArrayList<TreeNode> rtnp, int level){
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int currLevel=0;
        while(currLevel<level){
            int size=queue.size();
            while(size-->0){
                TreeNode node=queue.removeFirst();
                if(node.left!=null && rtnp.indexOf(node.left)==-1)
                    queue.add(node.left);
                if(node.right!=null && rtnp.indexOf(node.right)==-1)
                    queue.add(node.right);
            }
            currLevel++;
        }
        List<Integer> ans=new ArrayList<>();
        for(TreeNode n:queue){
            ans.add(n.val);
        }
        return ans;
    }
    
    public ArrayList<TreeNode> getRootToNode(TreeNode root,TreeNode target){
        if(root==null){
            return new ArrayList<>();
        }
        if(root==target){
            ArrayList<TreeNode> l=new ArrayList<>();
            l.add(root);
            return l;
        }
        ArrayList<TreeNode> left=getRootToNode(root.left,target);
        if(left.size()!=0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=getRootToNode(root.right,target);
        if(right.size()!=0){
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}