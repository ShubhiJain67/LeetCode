/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    int []list;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode node=head;
        int len=0,i=0;
        while(node!=null){
            len++;
            node=node.next;
        }
        list=new int[len];
        node=head;
         while(node!=null){
             list[i++]=node.val;
             node=node.next;
         }
        return listToBST(0,len-1);
    }
    
    public TreeNode listToBST(int i,int j){
        if(i>j)
            return null;
        int mid=(i+j)/2;
        // System.out.println(i+" "+j+" "+list[mid]);
        TreeNode node=new TreeNode(list[mid]);
        node.left=listToBST(i,mid-1);
        node.right=listToBST(mid+1,j);
        return node;        
    }
}