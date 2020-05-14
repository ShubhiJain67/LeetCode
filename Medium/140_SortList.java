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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
			
		// Finding the mid of the linked list and breaking the the list in two parts
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        mid=mid.next;
        slow.next=null;
		
		//recursive calls to sort the 2 seperated lists
        ListNode a=sortList(head);
        ListNode b=sortList(mid);
		
		//merging the 2 sorted lists
        return merge(a,b);
    }
    public ListNode merge(ListNode a,ListNode b){
        if(a==null) return b;
        if(b==null) return a;
        ListNode head;
        ListNode cur;
        if(a.val<b.val){
            head=a;
            cur=a;
            a=a.next;
        }else{
            head=b;
            cur=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.val<b.val){
                cur.next=a;
                cur=cur.next;
                a=a.next;
            }else{
                cur.next=b;
                cur=cur.next;
                b=b.next;
            }
        }
        if(a!=null)
            cur.next=a;
        if(b!=null)
            cur.next=b;
        return head;
    }
}