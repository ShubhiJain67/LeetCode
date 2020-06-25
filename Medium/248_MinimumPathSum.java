class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        dp=new int[grid.length][grid[0].length];
        return getCount(grid,0,0,grid.length-1,grid[0].length-1);
    }
    int dp[][];
    private int getCount(int [][] grid,int si,int sj,int ei,int ej){
        if(si==ei && sj==ej)
            return grid[si][sj];
        if(dp[si][sj]!=0)
            return dp[si][sj];
        int getLeft=Integer.MAX_VALUE,getRight=Integer.MAX_VALUE;
        if(si+1<=ei)
            getLeft=getCount(grid,si+1,sj,ei,ej);
        if(sj+1<=ej)
            getRight=getCount(grid,si,sj+1,ei,ej);
        dp[si][sj]=Math.min(getLeft,getRight)+grid[si][sj];
        return dp[si][sj];
    }
}