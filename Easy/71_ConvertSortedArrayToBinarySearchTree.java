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
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }
    public TreeNode create(int[] nums,int i,int j){
        if(i>j) return null;
        int mid=(i+j)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=create(nums,i,mid-1);
        node.right=create(nums,mid+1,j);
        return node;
    }
}