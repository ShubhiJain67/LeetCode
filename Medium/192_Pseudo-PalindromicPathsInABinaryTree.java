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
    ArrayList<String> path;
    public int pseudoPalindromicPaths (TreeNode root) {
        path=new ArrayList<>();
        getAllPaths(root,"");
        int count=0;
        for(String p:path){
           count+= isPalindromic(p);
        }
        return count;
    }
    public void getAllPaths(TreeNode root,String ans){
        if(root.left==null && root.right==null){
            path.add(ans+root.val);
            return;
        }
        if(root.left!=null){
            getAllPaths(root.left,ans+root.val);
        }
        if(root.right!=null){
            getAllPaths(root.right,ans+root.val);
        }
    }
    public int isPalindromic(String s){
        int [] count=new int[10];
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'0';
            count[c]++;
        }
        int odd=0;
        int even=0;
        for(int c:count){
            if(c%2==0)
                even++;
            else
                odd++;
        }
        if(odd<2)
            return 1;
        return 0;
    }
}