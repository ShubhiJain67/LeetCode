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
    public void reorderList(ListNode head){
        if(head==null || head.next==null || head.next.next==null)
            return ;
        ListNode first=head, second=head.next, lastSecond=head.next, last=head.next;
        while(first!=lastSecond && last!=null){
            while(last.next!=null){
                lastSecond=last;
                last=last.next;
            }
            first.next=last;
            lastSecond.next=null;
            last.next=second;
            first=second;
            second=first.next;
            lastSecond=first;
            last=second;
            while(last!=null && last.next!=null){
                lastSecond=last;
                last=last.next;
            }
        }
    }
}