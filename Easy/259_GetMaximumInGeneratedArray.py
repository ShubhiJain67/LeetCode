class Solution(object):
    def getMaximumGenerated(self, n):
        return self.get_maximum_iterative(n)

    # TC - O(n)
    # SC - O(n)
    def get_maximum_iterative(self, n):
        result = [0]*(n+1)
        max_result = 0
        for num in range(0,n+1):
            if num == 0:
                value = 0
            elif num == 1:
                value = 1
            elif num & 1 == 0:
                value = result[num>>1]
            elif num & 1 == 1:
                value = result[num>>1] + result[(num>>1) + 1]
            result[num] = value
            max_result = max(max_result, value)
            # print("{} : {}".format(num, result[num]))
        return max_result
