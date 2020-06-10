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
    public int numComponents(ListNode head, int[] G) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:G)
            list.add(i);
        int count=0;
        boolean markT=true;
        while(head!=null){
            if(list.indexOf(head.val)!=-1){
                if(markT){
                    count++;
                    markT=false;
                }                
            }
            else
                markT=true;
            head=head.next;
        }        
        return count;
    }
}