class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length-1;
        int m=grid[0].length-1;
        if(grid[n][m]>=0) return 0;
        if(grid[0][0]<0) return (m+1)*(n+1);
        int start=0;
        int ans=0;
        for(int i=n;i>=0;i--){
            if(grid[i][m]>=0) return ans;
            start=getStart(grid[i],start,m);
            ans+=(m-start+1);
        }
        return ans;
    }
    public int getStart(int []arr,int s,int e){
        while(s<e){
            int mid=(s+e)/2;
            if(arr[mid]>=0) s=mid+1;
            else e=mid;
        }
        return s;
    }
}