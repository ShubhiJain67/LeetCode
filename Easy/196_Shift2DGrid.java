class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid[0].length;
        int n=grid.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<n;i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j=0;j<m;j++)
                newRow.add(0);
             ans.add(newRow);
        }
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                ans.get((i+(j+k)/m)%n).set((j+k)%m,grid[i][j]);
        return ans;
    }
}