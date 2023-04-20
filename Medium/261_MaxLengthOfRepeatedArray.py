class Solution(object):
    def findLength(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        
        matches = self.get_array_matches(nums1, nums2)
        # print(matches)
        longest_match = self.get_longest_match(matches)
        return longest_match
    
    def get_array_matches(self, nums1, nums2):
        match = []
        for index in range(len(nums1)):
            match.append([False]*len(nums2))
        
        for index1 in range(len(nums1)):
            for index2 in range(len(nums2)):
                match[index1][index2] = nums1[index1] == nums2[index2]
        return match
    
    def get_longest_match(self, matches):
        longest_match = 0
        for row in range(len(matches)-1, -1, -1):
            for col in range(len(matches[0]) - 1, -1, -1):
                if matches[row][col]:
                    longest_match = max(longest_match, self.get_match_length(row, col, matches))
        return longest_match

    def get_match_length(self, row, col, matches):
        match_len = 0
        while row >= 0 and col >= 0 and matches[row][col]:
            matches[row][col] = False
            row -= 1
            col -= 1
            match_len += 1
        return match_len

