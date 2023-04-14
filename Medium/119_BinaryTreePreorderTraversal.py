# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #  preorder = self.preorder_recurrsive(root)
        preorder = self.preorder_iterative(root)
        return preorder

    def preorder_iterative(self, root):
        nodes_to_traverse = [root]
        preorder = []
        while(len(nodes_to_traverse) > 0):
            # print("Entry - {}".format(nodes_to_traverse))
            curr = nodes_to_traverse.pop()
            if curr == None:
                continue
            preorder.append(curr.val)
            if curr.right:
                # print("Pushing Right {}".format(curr.right))
                nodes_to_traverse.append(curr.right)
            if curr.left:
                # print("Pushing Left {}".format(curr.left))
                nodes_to_traverse.append(curr.left)
            # print("Exit - {}".format(nodes_to_traverse))
        return preorder

    def preorder_recurrsive(self, root):
        if root == None:
            return None
        preorder = []
        preorder.append(root.val)
        if root.left:
            preorder.extend(self.preorder_recurrsive(root.left))
        if root.right:
            preorder.extend(self.preorder_recurrsive(root.right))
        return preorder

