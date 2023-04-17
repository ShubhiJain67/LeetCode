class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        total_length = len(nums)
        max_in_mid = self.get_max_in_mid(nums, k)
        return max_in_mid
    
    def get_max_in_mid(self, nums, k):
        orignal_max = k
        i=0
        j=0
        max_len = 0
        while j < len(nums) and i<=j :
            # print("k-{} i-{} j-{} max_len-{}".format(k, i, j, max_len))
            if nums[j]==1:
                j+=1
            elif k>0:
                k-=1
                j+=1
            else:
                max_len = max(max_len, j-i)
                if nums[i] == 0:
                    k = min(orignal_max, k+1)
                if i==j:
                    j+=1
                i+=1
        max_len = max(max_len, j-i)
        return max_len
