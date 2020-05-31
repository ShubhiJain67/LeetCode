/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null || root.right==null) return root;
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            int size=queue.size();
            Node pre=null;
            while(size-->0){
                Node n=queue.removeFirst();
                if(pre!=null)
                    pre.next=n;
                pre=n;
                if(n.left!=null)
                    queue.add(n.left);
                if(n.right!=null)
                    queue.add(n.right);
            }
        }
        return root;
    }
}
























