class Solution(object):
    def closedIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        self.close_all_islands_on_the_corners(grid)
        closed_islands = self.get_closed_islands(grid)
        return closed_islands
    
    def close_all_islands_on_the_corners(self, grid):
        for row in range(len(grid)):
            for column in range(len(grid[0])):
                if (row == 0 or column == 0 or row == len(grid) - 1 or column == len(grid[0]) - 1) and grid[row][column] == 0:
                    # Close these islands - make them water
                    self.mark_island(row, column, grid)
    
    def get_closed_islands(self, grid):
        closed_islands = 0
        for row in range(len(grid)):
            for column in range(len(grid[0])):
                if grid[row][column] == 0:
                    closed_islands += 1
                    # Cover this island with water so that it doesnot get counted again
                    self.mark_island(row, column, grid)
        return closed_islands

    def mark_island(self, row, column, grid):
        if row < 0 or column < 0 or row >= len(grid) or column >= len(grid[0]):
            return
        if grid[row][column] == 1:
            return
        grid[row][column] = 1
        # mark up
        self.mark_island(row - 1, column, grid)
        # mark down
        self.mark_island(row + 1, column, grid)
        # mark left
        self.mark_island(row, column - 1, grid)
        # mark right
        self.mark_island(row, column + 1, grid)
        
