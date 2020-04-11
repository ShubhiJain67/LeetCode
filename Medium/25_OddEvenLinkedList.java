/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode ans=head;
        ListNode ret=ans;
        head=head.next;
        ListNode other=head;
        while(head!=null){
            ans.next=head.next;
            if(ans.next!=null)
            ans=ans.next;
            if(head==null || ans==null) break;
            head.next=ans.next;
            head=head.next;
        }
        ans.next=other;
        return ret;
    }
}