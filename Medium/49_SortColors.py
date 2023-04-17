class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = len(nums) - 1
        
        while i<j and j >= 0 and i < len(nums):
            if nums[j] == 2:
               j-=1
            elif  nums[i] != 2:a
                i+=1
            else:
                nums[i], nums[j] = nums[j], nums[i]
                i+=1
                j-=1
        i = 0
        j = len(nums) - 1
        while j >= 0 and nums[j] == 2:
            j-=1
        while i<j and j >= 0 and i < len(nums):
            if nums[j] == 1:
               j-=1
            elif  nums[i] != 1:
                i+=1
            else:
                nums[i], nums[j] = nums[j], nums[i]
                i+=1
                j-=1
        return nums
            
