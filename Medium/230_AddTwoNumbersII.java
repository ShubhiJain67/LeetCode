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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=0,len2=0;
        ListNode help=l1;
        while(help!=null){
            len1++;
            help=help.next;
        }
        help=l2;
        while(help!=null){
            len2++;
            help=help.next;
        }
        if(len1>len2){
            Add(l1,l2,len1-len2);
        }else{
            Add(l2,l1,len2-len1);
        }
        if(carry!=0){
            ListNode node=new ListNode(1);
            node.next=ans;
            ans=node;
        }
        return ans;
    }
    int carry=0;
    ListNode ans=null;
    public void Add(ListNode l1,ListNode l2,int z){
        if(l1.next!=null){
            if(z==0)
                Add(l1.next,l2.next,z);
            else 
                Add(l1.next,l2,z-1);
        }
        int sum=l1.val+carry;
        if(z==0)
            sum+=l2.val;
        carry=sum/10;
        ListNode node=new ListNode(sum%10);
        node.next=ans;
        ans=node;
        
    }
}