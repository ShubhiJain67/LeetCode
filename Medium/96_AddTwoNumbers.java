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
        //return Approach1(l1, l2, 0);
        return Approach2(l1, l2);
    }
    
    // TC : O(n)
    // SC : O(n) : Stack Space
    public ListNode Approach1(ListNode l1, ListNode l2, int carry){
        ListNode node = null;
        if(l1 == null && l2 == null){ // Both List1 and List2 are exhausted only checking for any carry
            if(carry == 1){
                node = new ListNode(carry);
                node.next = null;
            }
        }
        else if(l1 == null){ // List1 is exhausted
            node = new ListNode((l2.val + carry) % 10);
            node.next = Approach1(l1, l2.next, (l2.val + carry) / 10);
        }
        else if(l2 == null){ // List2 is exhausted
            node = new ListNode((l1.val + carry) % 10);
            node.next = Approach1(l1.next, l2, (l1.val + carry) / 10);
        }
        else{ // Both Lists exist
            node = new ListNode((l1.val + l2.val + carry) % 10);
            node.next = Approach1(l1.next, l2.next, (l1.val + l2.val + carry) / 10);
        }
        return node;
    }
    
    // TC : O(n)
    // SC : O(1)
    public ListNode Approach2(ListNode l1, ListNode l2){
        ListNode node = null;
        int carry = 0;
        ListNode head = null;
        
        // Iterating over noth the lists ans creating the answer nodes simultaneousls
        while(l1 !=null || l2 != null){
            if(node == null){
                node = new ListNode(0);
                head = node;
            }
            else{
                node.next = new ListNode(0);
                node = node.next;
            }
            if(l1 == null){ // List1 is exhausted
                node.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            else if(l2 == null){ // List2 is exhausted
                node.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            else{ // Both Lists exist
                node.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        
        // Both List1 and List2 are exhausted only checking for any carry
        if(carry == 1){
            node.next = new ListNode(carry);
        }
        
        return head;
    }
}