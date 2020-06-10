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
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode l1=head;
        ListNode l2=head.next;
        l1.next=null;
        while(l2!=null){
            ListNode insert=l2;
            l2=l2.next;
            insert.next=null;
            ListNode temp=l1;                
            ListNode prev=null;
            while(temp!=null && temp.val<insert.val){
                prev=temp;
                temp=temp.next;
            }
            if(prev!=null){
                insert.next=prev.next;
                prev.next=insert;
            }
            else{
               insert.next=l1;
               l1=insert;
            }
        }
        return l1;
    }
}