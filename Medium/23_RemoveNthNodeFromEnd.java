/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper=head,prev=null;
        ListNode node=head;
        while(n>0){
            helper=helper.next;
            n--;
        }
        while(helper!=null){
            prev=node;
            helper=helper.next;
            node=node.next;
        }
        if(prev==null){
            head=head.next;
        }       
        else{
            prev.next=node.next;
        }
        return head;
    }
    
}