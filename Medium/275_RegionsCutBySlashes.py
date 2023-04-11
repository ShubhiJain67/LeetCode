class Solution(object):
    def regionsBySlashes(self, grid):
        """
        :type grid: List[str]
        :rtype: int
        """
        grid_box = self.create_grid_box(grid)
        # print(grid_box)
        connections = self.get_initial_unconnected_indexes(len(grid))
        # print(connections)
        self.get_already_connected_indexes(connections, len(grid))
        # print(connections)
        regions = 1 # formed by already connected indexes
        new_regions = self.get_new_regions(connections, grid_box)
        # print(new_regions)
        return regions + new_regions


    def create_grid_box(self, grid):
        grid_len = len(grid)
        grid_box = []
        for row in range(0,grid_len):
            grid_box.append(['']*grid_len)
        for row in range(0,grid_len):
            for col in range(0,grid_len):
                grid_box[row][col] = grid[row][col]
        return grid_box

    def get_initial_unconnected_indexes(self, grid_len):
        connections = {}
        for index in range(0,(grid_len+1)*(grid_len+1)):
            connections[index] = {index}
        return connections

    def get_new_regions(self, connections, grid_box):
        regions = 0
        grid_len = len(grid_box)
        for row in range(0,grid_len):
            for col in range(0,grid_len):
                if grid_box[row][col] == '/':
                    left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
                    primary_left_bottom = self.get_primary_index(left_bottom, connections)
                    primary_right_top = self.get_primary_index(right_top, connections)
                    if primary_left_bottom == primary_right_top:
                        regions+=1
                    self.connect_two_indexes(left_bottom, right_top, connections)
                if grid_box[row][col] == '\\':
                    left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
                    primary_left_top = self.get_primary_index(left_top, connections)
                    primary_right_bottom = self.get_primary_index(right_bottom, connections)
                    if primary_left_top == primary_right_bottom:
                        regions+=1
                    self.connect_two_indexes(left_top, right_bottom, connections)
        return regions
                    



    def get_already_connected_indexes(self, connections, grid_len):
        # top edge of grid
        row = 0
        for col in range(0,grid_len):
            left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
            self.connect_two_indexes(left_top, right_top, connections)
        
        # left edge of grid
        col = 0
        for row in range(0,grid_len):
            left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
            self.connect_two_indexes(left_top, left_bottom, connections)
        
        # bottom edge of grid
        row = grid_len - 1
        for col in range(0,grid_len):
            left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
            self.connect_two_indexes(left_bottom, right_bottom, connections)
        
        # right edge of grid
        col = grid_len - 1
        for row in range(0,grid_len):
            left_top, right_top, left_bottom, right_bottom = self.get_index_for_a_cell(row,col,grid_len)
            self.connect_two_indexes(right_top, right_bottom, connections)
    
    def connect_two_indexes(self, index1, index2, connections):
        primary1 = self.get_primary_index(index1, connections)
        primary2 = self.get_primary_index(index2, connections)
        if primary1 < primary2:
            connections[primary1] = connections[primary1].union(connections[primary2])
            del connections[primary2]
        elif primary2 < primary1:
            connections[primary2] = connections[primary2].union(connections[primary1])
            del connections[primary1]
    
    def get_index_for_a_cell(self, row, col, grid_length):
        left_top = row * (grid_length + 1) + col
        right_top = left_top + 1
        left_bottom = left_top + grid_length + 1
        right_bottom = right_top + grid_length + 1
        return left_top, right_top, left_bottom, right_bottom
    
    def get_primary_index(self, index, connections):
        primary = index
        if index in connections:
            primary = index
        for primary_index, index_group in connections.items():
            if index in index_group:
                primary = primary_index
        # print("Finding {} - Found {}".format(index, primary))
        return primary
        
