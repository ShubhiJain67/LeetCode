class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # subsets = self.get_all_subsets_recursive(0, nums)
        subsets = self.get_all_subsets_iterative(nums)
        return subsets
    
    def get_all_subsets_iterative(self, nums):
        # print("{}".format(starting_index))
        subsets = [[]]
        for starting_index in range(len(nums) - 1, -1, -1):
            new_subsets = []
            for rest_subset in subsets:
                # print("Adding {}".format(rest_subset))
                new_subsets.append(rest_subset)
                new_subset = rest_subset[:]
                new_subset.append(nums[starting_index])
                # print("Adding {}".format(new_subset))
                new_subsets.append(new_subset)
            # print("Returning {}".format(subsets))
            subsets = new_subsets[:]
        return subsets

    def get_all_subsets_recursive(self, starting_index, nums):
        # print("{}".format(starting_index))
        if len(nums) == starting_index:
            return [[]]
        rest_subsets = self.get_all_subsets_recursive(starting_index + 1, nums)
        subsets = []
        for rest_subset in rest_subsets:
            # print("Adding {}".format(rest_subset))
            subsets.append(rest_subset)
            new_subset = rest_subset[:]
            new_subset.append(nums[starting_index])
            # print("Adding {}".format(new_subset))
            subsets.append(new_subset)
        # print("Returning {}".format(subsets))
        return subsets
