class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for index in range(len(nums)-2, -1, -1):
            include_current = nums[index]
            if (index+2) < len(nums):
                include_current += nums[index+2]
            exclude_current = nums[index+1]
            nums[index] = max(include_current, exclude_current)
        return nums[0]
