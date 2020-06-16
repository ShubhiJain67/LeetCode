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
    public ListNode partition(ListNode temp, int x) {
        ListNode smallHead=null;
        ListNode smallTail=null;
        ListNode bigHead=null;
        ListNode bigTail=null;
        while(temp!=null){
            if(temp.val<x){
                if(smallHead==null){
                    smallHead=temp;
                    smallTail=temp;
                }else{
                    smallTail.next=temp;
                    smallTail=smallTail.next;
                }
                temp=temp.next;
                smallTail.next=null;
            }else{
                if(bigHead==null){
                    bigHead=temp;
                    bigTail=temp;
                }else{
                    bigTail.next=temp;
                    bigTail=bigTail.next;
                }
                temp=temp.next;
                bigTail.next=null;
            }
        }
        if(smallHead==null)
            return bigHead;
        smallTail.next=bigHead;
            return smallHead;
    }
}