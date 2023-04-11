# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def allPossibleFBT(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        # return self.generate_all_complete_binary_trees_recursive(n)
        # return self.generate_all_complete_binary_trees_recursive_with_memoization(n, {})
        return self.generate_all_complete_binary_trees_iterative(n)
        
    def generate_all_complete_binary_trees_recursive(self, n):
        if n & 1 == 0:
            return []
        if n == 1:
            tree_node = TreeNode(
                val = 0,
                left = None,
                right = None
            )
            return [tree_node]
        nodes_on_left = 1
        nodes_on_right = n - 2
        trees = []
        while(nodes_on_right > 0):
            left_trees = self.generate_all_complete_binary_trees_recursive(nodes_on_left)
            right_trees = self.generate_all_complete_binary_trees_recursive(nodes_on_right)
            for left_tree in left_trees:
                for right_tree in right_trees:
                    tree_node = TreeNode(
                        val = 0,
                        left = left_tree,
                        right = right_tree
                    ) 
                    trees.append(tree_node)
            nodes_on_left+=2
            nodes_on_right-=2
        return trees
    
    def generate_all_complete_binary_trees_recursive_with_memoization(self, n, memory):
        if n & 1 == 0:
            return []
        if n == 1:
            tree_node = TreeNode(
                val = 0,
                left = None,
                right = None
            )
            return [tree_node]
        if n in memory:
            return memory[n]
        nodes_on_left = 1
        nodes_on_right = n - 2
        trees = []
        while(nodes_on_right > 0):
            left_trees = self.generate_all_complete_binary_trees_recursive_with_memoization(nodes_on_left,memory)
            right_trees = self.generate_all_complete_binary_trees_recursive_with_memoization(nodes_on_right,memory)
            for left_tree in left_trees:
                for right_tree in right_trees:
                    tree_node = TreeNode(
                        val = 0,
                        left = left_tree,
                        right = right_tree
                    ) 
                    trees.append(tree_node)
            nodes_on_left+=2
            nodes_on_right-=2
        memory[n] = trees
        return trees

    def generate_all_complete_binary_trees_iterative(self, n):
        memory = [[]]*(n+1)
        if n & 1 == 0:
            return []
        for node_count in range (1, n+1, 2):
            trees = []
            if node_count == 1:
                tree_node = TreeNode(
                    val = 0,
                    left = None,
                    right = None
                )
                trees.append(tree_node)
            else:
                nodes_on_left = 1
                nodes_on_right = node_count - 2
                trees = []
                while(nodes_on_right > 0):
                    left_trees = memory[nodes_on_left]
                    right_trees = memory[nodes_on_right]
                    for left_tree in left_trees:
                        for right_tree in right_trees:
                            tree_node = TreeNode(
                                val = 0,
                                left = left_tree,
                                right = right_tree
                            ) 
                            trees.append(tree_node)
                    nodes_on_left+=2
                    nodes_on_right-=2
            memory[node_count] = trees
        return memory[n]
