class Solution {
    public int minFallingPathSum(int[][] A) {
        int n=A.length,m=A[0].length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int val=A[i][j];
                A[i][j]=val+A[i+1][j];
                if(j-1>=0)
                    A[i][j]=Math.min(val+A[i+1][j-1],A[i][j]);
                if(j+1<m)
                    A[i][j]=Math.min(val+A[i+1][j+1],A[i][j]);
            }
        }
        int ans=A[0][0];
        for(int j=0;j<m;j++)
            ans=Math.min(ans,A[0][j]);
        return ans;
    }
}