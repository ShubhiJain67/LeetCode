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
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        List<Integer> inList = new ArrayList<>();
        while(head != null) {
            inList.add(head.val);
            head = head.next;
        }        
        int[] out = new int[inList.size()];        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);        
        for(int index = 1; index < inList.size(); index++) {
            int value = inList.get(index);        
            if(stack.isEmpty() || value <= inList.get(stack.peek())) {
                stack.push(index);
            } else {
                while(!stack.isEmpty() && value > inList.get(stack.peek())) {
                    out[stack.pop()] = value;
                }
                stack.push(index);
            }
        }
        return out;
    }
}