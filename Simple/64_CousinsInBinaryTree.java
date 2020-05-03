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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        if(x==y) return false;
        int xLevel=-1;
        int yLevel=-1;
        int xParent=-1;
        int yParent=-1;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(queue.size()!=0){
            int size=queue.size();
            while(size-->0){
                TreeNode node=queue.removeFirst();
                if(node.left!=null){
                    if(node.left.val==x){
                        xLevel=level+1;
                        xParent=node.val;
                    }
                    else if(node.left.val==y){
                        yLevel=level+1;
                        yParent=node.val;
                    }
                    else{
                        queue.addLast(node.left);
                    }
                }
                if(node.right!=null){
                    if(node.right.val==x){
                        xLevel=level+1;
                        xParent=node.val;
                    }
                    else if(node.right.val==y){
                        yLevel=level+1;
                        yParent=node.val;
                    }
                    else{
                        queue.addLast(node.right);
                    }
                }
            }
            level++;
            if(xLevel!=-1 || yLevel!=-1 || xParent!=-1 ||yParent!=-1){
                break;
            }
        }
        // System.out.println(x+" : level : "+xLevel+" parent : "+xParent);
        // System.out.println(y+" : level : "+yLevel+" parent : "+yParent);
        if(xLevel==-1 || yLevel==-1 || xParent==-1 ||yParent==-1)
            return false;
        return xLevel==yLevel && xParent!=yParent;
    }
}