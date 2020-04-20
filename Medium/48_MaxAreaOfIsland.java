class Solution {
    int[][] grid;
    public int maxAreaOfIsland(int[][] board) {
        grid=board;
        if(grid.length==0) return 0;
        int count=0;
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    // for(int k=0;k<grid.length;k++){
                    //     for(int l=0;l<grid[0].length;l++){
                    //         System.out.print(board[k][l]+" ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println(max);
                    // System.out.println("*********************");
                    count=DFS(i,j,grid);
                    if(max<count){
                        max=count;
                    }                    
                }
            }
        }
        return max;
    }
    
    int [][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public int DFS(int r,int c,int [][] grid){
        if(grid[r][c]==0) {return 0;}
        int count=1;
        grid[r][c]=0;
        if(r-1>=0 && grid[r-1][c]==1) {
            count+=DFS(r-1,c,grid);
        }
        if(c-1>=0 && grid[r][c-1]==1){
            count+=DFS(r,c-1,grid);
        }
        if(r+1<grid.length && grid[r+1][c]==1){
            count+=DFS(r+1,c,grid);
        }
        if(c+1<grid[0].length && grid[r][c+1]==1){
            count+=DFS(r,c+1,grid);
        }
        return count;
    }
}

// [["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]