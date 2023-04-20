class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        match = []
        for index in range(len(s)):
            match.append([False]*(len(s)))
        
        count = 0
        for column in range(0, len(s)):
            row = 0
            col = column
            while row < len(s) and col < len(s):
                if row == col:
                    match[row][col] = True
                else:
                    if s[row] == s[col]:
                        match[row][col] = match[row + 1][col - 1] if (row+1) != col else True
                if match[row][col]:
                    count+=1
                row+=1
                col+=1
        return count
