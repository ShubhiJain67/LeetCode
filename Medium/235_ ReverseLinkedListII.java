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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n || head==null || head.next==null)
            return head;
        int index=1;
        ListNode ansHead=null;
        ListNode ansTail=null;
        while(index<m){
            if(index==1){
                ansHead=head;
                
            }
            ansTail=head;
            index++;  
            head=head.next;          
        }
        ListNode temp=null;
        while(index<=n){
            ListNode t=head;
            head=head.next;
            t.next=temp;
            temp=t;
            index++;
        }
        if(ansHead==null)
            ansHead=temp;
        else
            ansTail.next=temp;
        if(ansTail==null)
            ansTail=ansHead;
        while(ansTail!=null && ansTail.next!=null)
            ansTail=ansTail.next;
        if(ansTail!=null)
            ansTail.next=head;
        return ansHead;
    }
}