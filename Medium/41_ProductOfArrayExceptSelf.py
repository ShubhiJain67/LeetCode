class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        product = [1]
        pre_product = 1
        for num_index in range(1, len(nums)):
            num = nums[num_index - 1]
            pre_product = pre_product * num
            product.append(pre_product)

        post_product = 1
        for num_index in range(len(nums) - 2, -1, -1):
            num = nums[num_index + 1]
            post_product = post_product * num
            product[num_index] = product[num_index] * post_product
        return product
