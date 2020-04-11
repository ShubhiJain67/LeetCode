/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=head,cur=head.next,prevprev=head;
        prev.next=cur.next;
        cur.next=prev;
        head=cur;
        cur=prev.next;
        if(cur!=null){
            prevprev=prev;
            prev=prev.next;
            cur=cur.next;
        }
        while(cur!=null){
            prev.next=cur.next;
            prevprev.next=cur;
            cur.next=prev;
            prevprev=prev;
            prev=prev.next;
            if(prev==null) break;
            cur=prev.next;
        }
        return head;
        
    }
}