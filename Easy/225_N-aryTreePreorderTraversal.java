/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans= new ArrayList<Integer>();
        if(root==null) return ans;
        Stack<Node>  stack=new Stack<Node>();
        stack.push(root);
        while(stack.isEmpty()!=true){
            Node num=stack.pop();
            ans.add(num.val);
            // System.out.println(num.val);
            for(int i=num.children.size()-1;i>=0;i--){
                // System.out.println(1);
                stack.push(num.children.get(i));
            }
        }
        return ans;
    }
}