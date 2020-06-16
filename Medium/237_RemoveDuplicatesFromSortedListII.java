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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode ansHead=null;
        ListNode ansTail=null;
        ListNode tempHead=head;
        ListNode tempTail=head.next;
        boolean add=true;
        while(tempTail!=null){
            if(tempHead.val==tempTail.val){
                while(tempTail!=null && tempHead.val==tempTail.val){
                    tempTail=tempTail.next;
                }
                if(tempTail==null){
                    add=false;
                    break;
                }
                tempHead=tempTail;
                tempTail=tempTail.next;
            }else{
                if(ansHead==null){
                    ansHead=tempHead;
                    ansTail=tempHead;
                }else{
                    ansTail.next=tempHead;
                    ansTail=ansTail.next;
                }
                tempHead=tempTail;
                tempTail=tempTail.next;
                ansTail.next=null;
            }
        }
        if(add){
            if(ansHead==null){
                ansHead=tempHead;
                ansTail=tempHead;
            }else{
                ansTail.next=tempHead;
                ansTail=ansTail.next;
            }
            ansTail.next=null;
        }
        return ansHead;
    }
}