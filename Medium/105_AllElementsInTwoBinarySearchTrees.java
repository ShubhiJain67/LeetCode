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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a1=inorder(root1);
        List<Integer> a2=inorder(root2);
        return merge(a1,a2);
    }
    public List<Integer> inorder(TreeNode node){
        if(node==null) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        if(node.left!=null)
            ans.addAll(inorder(node.left));
        ans.add(node.val);
        if(node.right!=null)
            ans.addAll(inorder(node.right));
        return ans;
    }
    public List<Integer> merge(List<Integer> a1,List<Integer> a2){
        List<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        int a1len=a1.size();
        int a2len=a2.size();
        while(i<a1len && j<a2len){
            int n=a1.get(i);
            int m=a2.get(j);
            if(n<m){
                ans.add(n);
                i++;
            }
            else if(n>m){
                ans.add(m);
                j++;
            }
            else if(n==m){
                ans.add(m);
                ans.add(n);
                i++;
                j++;
            }
        }
        while(i<a1len){
            ans.add(a1.get(i));
            i++;
        }
        while(j<a2len){
            ans.add(a2.get(j));
            j++;
        }
        return ans;
    }
}