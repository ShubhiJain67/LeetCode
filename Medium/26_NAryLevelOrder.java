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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        Queue<Node> q=new LinkedList<Node>();
        if(root==null) return list;
        q.add(root);
        q.add(null);
        while(q.size()!=0){
            Node t=q.remove();
            while(t!=null){
                for(Node tr:t.children){
                    q.add(tr);
                }
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