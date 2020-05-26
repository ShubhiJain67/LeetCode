/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        if(root.children.size()==0){
            ans.add(root.val);
            return ans;
        }
        else{
            for(int i=0;i<root.children.size();i++){
                List<Integer> ret=postorder(root.children.get(i));
                ans.addAll(ret);
            }
        }
        ans.add(root.val);
        return ans;
    }
}