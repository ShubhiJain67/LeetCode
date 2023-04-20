# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        return self.identical_trees(root.left, root.right)
        
    def identical_trees(self, left, right):
        found = False
        if not left and not right:
            # print("Could not find both left and right")
            found = True
        if left and right and left.val == right.val:
            found = self.identical_trees(left.left, right.right) and self.identical_trees(left.right, right.left)
            # print("At {} and {} - {}".format(left.val, right.val, found))
        return found
