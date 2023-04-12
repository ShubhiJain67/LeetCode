import copy
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # path_count = self.get_unique_paths_recursive(0,0,m-1,n-1)
        # path_count = self.get_unique_paths_recursive_with_memoization(0,0,m-1,n-1, {})
        # path_count = self.get_unique_paths_iterative_dp(0,0,m-1,n-1)
        path_count = self.get_unique_paths_iterative_space_effective_dp(0,0,m-1,n-1)
        return path_count

    def get_unique_paths_recursive(self, start_i, start_j, end_i, end_j):
        # print("At : {},{}".format(start_i, start_j))
        if start_i == end_i and start_j == end_j:
            return 1
        count_down = 0
        count_right = 0
        if start_i + 1 <= end_i:
            count_down = self.get_unique_paths_recursive(start_i + 1, start_j, end_i, end_j)
        if start_j + 1 <= end_j:
            count_right = self.get_unique_paths_recursive(start_i, start_j + 1, end_i, end_j)
        return count_down + count_right
    
    def get_unique_paths_recursive_with_memoization(self, start_i, start_j, end_i, end_j, memory):
        if start_i == end_i and start_j == end_j:
            return 1
        coordinate_expression = "{}-{}".format(start_i, start_j)
        if coordinate_expression in memory:
            return memory[coordinate_expression]
        count_down = 0
        count_right = 0
        if start_i + 1 <= end_i:
            count_down = self.get_unique_paths_recursive_with_memoization(start_i + 1, start_j, end_i, end_j, memory)
        if start_j + 1 <= end_j:
            count_right = self.get_unique_paths_recursive_with_memoization(start_i, start_j + 1, end_i, end_j, memory)
        memory[coordinate_expression] = count_down + count_right
        return memory[coordinate_expression]
    
    def get_unique_paths_iterative_dp(self, start_i, start_j, end_i, end_j):
        board = []
        for row in range(end_i+1):
            board.append([0]*(end_j + 1))
        for row in range(end_i, -1, -1):
            for col in range(end_j, -1, -1):
                if row == end_i and col == end_j:
                    board[row][col] = 1
                elif row == end_i:
                    board[row][col] = board[row][col + 1]
                elif col == end_j:
                    board[row][col] = board[row + 1][col]
                else:
                    board[row][col] = board[row + 1][col] + board[row][col + 1]
        return board[0][0]
    
    def get_unique_paths_iterative_space_effective_dp(self, start_i, start_j, end_i, end_j):
        row_1 = [0]*(end_j + 1)
        row_2 = [0]*(end_j + 1)
        
        for row in range(end_i, -1, -1):
            for col in range(end_j, -1, -1):
                if row == end_i and col == end_j:
                    row_2[col] = 1
                elif row == end_i:
                    row_2[col] = row_2[col + 1]
                elif col == end_j:
                    row_1[col] = row_2[col]
                else:
                    row_1[col] = row_2[col] + row_1[col + 1]
            if row < end_i:
                row_2 = copy.deepcopy(row_1)
                row_1 = [0]*(end_j + 1)
        return row_2[col]
        
