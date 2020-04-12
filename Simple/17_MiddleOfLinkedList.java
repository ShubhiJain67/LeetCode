/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            head=head.next;
            temp=temp.next.next;
        }
        return head;
        
    }
}