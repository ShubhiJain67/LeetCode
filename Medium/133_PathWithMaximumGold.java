class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                int currGold = dfs(i ,j, grid); 
                maxGold = Math.max(currGold, maxGold);
            }
        }
        return maxGold ;
    }
    int dir[][]={{1,0},{0,1},{0,-1},{-1,0}};
    public int dfs(int i, int j, int [][] grid){
        if(grid[i][j] == 0 )    return 0;
        int max=0,num=0;
        for(int d=0;d<dir.length;d++){
            int ii=i+dir[d][0];
            int jj=j+dir[d][1];
            int temp = grid[i][j];
            grid[i][j] = 0;
            if(ii>=0 && jj>=0 && ii<grid.length && jj<grid[0].length)
                num=temp+dfs(ii,jj,grid);
            if(max<num)
                max=num;
            grid[i][j]=temp;
        }
        return max;
    }
}