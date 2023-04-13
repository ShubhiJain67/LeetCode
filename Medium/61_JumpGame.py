class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # can_jump = self.jump_and_reach_approach_1(0,len(nums)-1 ,nums)
        can_jump = self.jump_and_reach_approach_2(nums)
        return can_jump
    
    # TC - O(n)
    # SC - O(1)
    def jump_and_reach_approach_2(self, jumps):
        maximum_reach = 0
        curr_index = 0
        while curr_index <= maximum_reach and curr_index < len(jumps):
            curr_reach = curr_index + jumps[curr_index]
            maximum_reach = max(maximum_reach, curr_reach)
            if maximum_reach >= len(jumps) - 1:
                return True
            curr_index += 1
        if maximum_reach >= len(jumps) - 1:
            return True
        return False

    # TC - O(n^2)
    # SC - O(n)
    def jump_and_reach_approach_1(self, current_index, end_index, jumps):
        can_reach = [False]*len(jumps)
        for curr_index in range(len(jumps) - 1, -1, -1):
            if curr_index == len(jumps) - 1:
                can_reach[curr_index] = True
            else:
                for jump in range(1, jumps[curr_index]+1):
                    if can_reach[curr_index + jump]:
                        can_reach[curr_index] = True
                        break
        return can_reach[0]
