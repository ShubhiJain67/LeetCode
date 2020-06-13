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
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length==0)
            return null;
        return mergeSort(list,0,list.length-1);
    }
    private ListNode mergeSort(ListNode[] list,int i,int j){
        if(i==j)
            return list[i];
        int mid=(i+j)/2;
        ListNode l1=mergeSort(list,i,mid);
        ListNode l2=mergeSort(list,mid+1,j);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode ans=null;
        ListNode curr=null;
        if(l1.val<l2.val){
            ans=l1;
            curr=l1;
            l1=l1.next;
        }else{
            ans=l2;
            curr=l2;
            l2=l2.next;
        }
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;
            }else{
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        if(l1!=null)
            curr.next=l1;
        if(l2!=null)
            curr.next=l2;
        return ans;
    }
    
    
}
