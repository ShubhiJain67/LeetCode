/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int carry=0;
        sum=(l1.val+l2.val);
        ListNode ans=new ListNode(sum%10);
        ListNode helper=ans;
        l1=l1.next;
        l2=l2.next; 
        carry=sum/10;
        while(l1!=null && l2!=null){
            sum=(l1.val+l2.val+carry);
            carry=sum/10; 
            helper.next=new ListNode(sum%10);
            helper=helper.next;
            l1=l1.next;
            l2=l2.next;           
        }
        while(l1!=null){
            sum=(l1.val+carry);
            carry=sum/10; 
            helper.next=new ListNode(sum%10);
            helper=helper.next;
            l1=l1.next;
        }
        while(l2!=null){
            sum=(l2.val+carry);
            carry=sum/10; 
            helper.next=new ListNode(sum%10);
            helper=helper.next;
            l2=l2.next;           
        }
        if(carry==1)
            helper.next=new ListNode(1);
        return ans;
    }
}
