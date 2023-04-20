# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None:
            return False
        
        slow = head
        if head.next==None or head.next.next == None:
            return False
        fast=head.next.next

        while slow and slow != fast:
            slow=slow.next
            if not fast.next or not fast.next.next:
                return False
            fast = fast.next.next
            
        return slow==fast
