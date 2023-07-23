/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
      // return reverseIterative(head);
      return reverseRecursive(head);
    }
    private ListNode reverseIterative(ListNode head){
      if(head==null || head.next==null) return head;
        if(head.next.next==null){
            int num=head.val;
            head.val=head.next.val;
            head.next.val=num;
            return head;
        }
        ListNode prev=null,cur=head,nex=head.next;
        while(cur!=null){
            cur.next=prev;
            prev=cur;
            cur=nex;
            if(nex!=null)
            nex=nex.next;
        }        
        return prev;
    }
    private ListNode reverseRecursive(ListNode head){
      if(head == null) {
          return head;
      }
      // last node or only one node
      if(head.next == null) {
          return head;
      }
      ListNode newHeadNode = reverseRecursive(head.next);
      // change references for middle chain
      head.next.next = head;
      head.next = null;
      // send back new head node in every recursion
      return newHeadNode;      
    }
}
