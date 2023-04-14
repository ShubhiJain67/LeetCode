class Node():
    val = None
    count = None
    def __init__(self, val, count):
        self.val = val
        self.count = count
    
    def __repr__(self):
        return "{},{}".format(self.val, self.count)
    
class Solution(object):
    def removeDuplicates(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        node_stack = []
        for character in s:
            node_top = node_stack[-1] if node_stack else None
            if node_top and node_top.val == character:
                curr_count = node_top.count + 1
                if curr_count == k:
                    while node_top and node_top.val == character:
                        node_stack.pop()
                        node_top = node_stack[-1] if node_stack else None
                else:
                    node_stack.append(Node(character, curr_count))
            else:
                node_stack.append(Node(character, 1))
        new_string = ""
        for node in node_stack:
            new_string += node.val
        return new_string
