class Solution {
    char[][] grid;
    public int numIslands(char[][] board) {
        grid=board;
        if(grid.length==0) return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    DFS(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    int [][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public void DFS(int r,int c,char [][] grid){
        if(grid[r][c]=='0') return ;
        grid[r][c]='0';
        if(r-1>=0) {
            DFS(r-1,c,grid);
        }
        if(c-1>=0){
            DFS(r,c-1,grid);
        }
        if(r+1<grid.length){
            DFS(r+1,c,grid);
        }
        if(c+1<grid[0].length){
            DFS(r,c+1,grid);
        }
    }
}

// [["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]