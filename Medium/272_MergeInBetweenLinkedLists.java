/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        a--;
        ListNode currPointer = list1;
        int currIndex = 0;
        while (currIndex < a && currPointer != null) {
            currPointer = currPointer.next;
            currIndex++;
        }
        ListNode tempPointer = null;
        if (!(currIndex < a && currPointer == null)) {
            if (currPointer != null && currIndex == a) {
                tempPointer = currPointer.next;
                currPointer.next = list2;
                if (list2 != null) {
                    while (currPointer.next != null) {
                        currPointer = currPointer.next;
                    }
                }
            }
            while (currIndex < b && tempPointer != null) {
                tempPointer = tempPointer.next;
                currIndex++;
            }
            if (currIndex == b) {
                currPointer.next = tempPointer;
            }
        }
        return list1;
    }
}