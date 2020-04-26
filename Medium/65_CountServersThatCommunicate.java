class Solution {
    public int countServers(int[][] grid) {
        boolean[][] operate = new boolean[grid.length][grid[0].length];
        List<Integer> l = new LinkedList<Integer>();
        int count = 0;
        
        // For row operation
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == 1) l.add(j);
            }
            if(l.size() > 1) 
            {
                for(int j : l) 
                {
                    if(!operate[i][j])
                    {
                        operate[i][j] = true;
                        count++;
                    }
                }
            }
            l.clear();
        }
        
        // For Column Operation
        for(int j = 0 ; j < grid[0].length ; j++)
        {
            for(int i = 0 ; i < grid.length ; i++)
            {
                if(grid[i][j] == 1) l.add(i);
            }
            if(l.size() > 1)
            {
                for(int i : l)
                {
                    if(!operate[i][j])
                    {
                        operate[i][j] = true;
                        count++;
                    }
                }
            }
            l.clear();
        }
        return count;
    }
}