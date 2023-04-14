# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # inorder = self.inorder_recurrsive(root)
        inorder = self.inorder_iterative(root)
        return inorder

    def inorder_iterative(self, root):
        nodes_to_traverse = [root]
        inorder = []
        while(len(nodes_to_traverse) > 0):
            # print("Entry - {}".format(nodes_to_traverse))
            curr = nodes_to_traverse[-1]
            # print("processing {}".format(curr))
            if curr == None:
                nodes_to_traverse.pop()
                continue
            if curr.left:
                # print("Pushing Left {}".format(curr.left))
                nodes_to_traverse.append(curr.left)
                curr.left = None
            else:
                inorder.append(curr.val)
                nodes_to_traverse.pop()
                if curr.right:
                    # print("Pushing Right {}".format(curr.right))
                    nodes_to_traverse.append(curr.right)
        
            # print("Exit - {}".format(nodes_to_traverse))
        return inorder

    
    def inorder_recurrsive(self, root):
        if root == None:
            return None
        inorder = []
        if root.left:
            inorder = self.inorder_recurrsive(root.left)
        inorder.append(root.val)
        if root.right:
            inorder.extend(self.inorder_recurrsive(root.right))
        return inorder

