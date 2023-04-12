# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        list_length = self.get_list_length(head)
        if list_length == 0:
            return head
        new_head_distance = list_length - (k % list_length)
        new_head = self.get_new_starting_head(head, new_head_distance)
        if new_head == None:
            return head
        head = self.disconnect_head_from_new_node(head, new_head_distance)
        head = self.connect_new_head_with_old_head(head, new_head)
        return head
        
    def get_list_length(self, head):
        count = 0
        while head:
            head = head.next
            count += 1
        return count
    
    def get_new_starting_head(self, head, new_head_distance):
        new_head = head
        while new_head_distance > 0:
            new_head = new_head.next
            new_head_distance -= 1
        return new_head
    
    def disconnect_head_from_new_node(self, head, new_head_distance):
        current_node = head
        new_head_distance -= 1
        while new_head_distance > 0:
            current_node = current_node.next
            new_head_distance-=1
        current_node.next = None
        return head
    
    def connect_new_head_with_old_head(self, head, new_head):
        current_node = new_head
        while current_node.next:
            current_node = current_node.next
        current_node.next = head
        return new_head
