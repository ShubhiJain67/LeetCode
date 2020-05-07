class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [] rowSkyline=new int[n];
        int colSkyline[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>rowSkyline[i])
                    rowSkyline[i]=grid[i][j];
                if(grid[i][j]>colSkyline[j])
                    colSkyline[j]=grid[i][j];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int min=rowSkyline[i]<colSkyline[j]?rowSkyline[i]:colSkyline[j];
                ans=ans+min-grid[i][j];
            }
        }
        return ans;
    }
}