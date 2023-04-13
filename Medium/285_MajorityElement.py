class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # majority_element = self.sorting_nums(nums)
        # majority_element = self.bit_manipulation(nums)
        majority_element = self.boyer_moore_voting_algorithm(nums)
        return majority_element
    
    def sorting_nums(self, nums):
        nums = sorted(nums)
        middle = len(nums)>>1 if len(nums) & 1 else (len(nums) + 1)>>1
        return nums[middle]
    
    def bit_manipulation(self, nums):
        majority_element = 0
        for bit_index in range(0, 32):
            bit = 1 << bit_index
            bit_count= 0
            for num in nums:
                if num & bit:
                    bit_count+=1
            
            if bit_count > len(nums)/2:
                majority_element = majority_element | bit
        
        return majority_element

    def boyer_moore_voting_algorithm(self, nums):
        majority_element = 0
        count = 0
        for num in nums:
            if count == 0:
                majority_element = num
            if num == majority_element:
                count += 1
            else:
                count -= 1
        return majority_element
