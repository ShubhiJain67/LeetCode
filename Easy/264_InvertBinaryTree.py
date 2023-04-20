# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        left_tree = self.invertTree(root.left)
        right_tree = self.invertTree(root.right)
        root.left = right_tree
        root.right = left_tree
        return root
