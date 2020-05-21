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
class BSTIterator {
    LinkedList<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        queue=new LinkedList<>();
        InOrder(root);
    }
    private void InOrder(TreeNode root){
        if(root==null)
            return;
        InOrder(root.left);
        queue.add(new TreeNode(root.val));
        InOrder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node=queue.removeFirst();
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */