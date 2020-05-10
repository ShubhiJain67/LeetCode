class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n], num=1;
        for(int i=0;i<=n/2;i++){ //runs only n/2 times because in evvery loop 2 rows are taken care of
            for(int j=i;j<n-i;j++)   ans[i][j]=num++;  //Going from left to right			
            for(int j=i+1;j<n-i;j++) ans[j][n-i-1]=num++; //Going from top to botom
            for(int j=n-i-2;j>=i;j--) ans[n-i-1][j]=num++; //Going from right to left
            for(int j=n-i-2;j>i;j--) ans[j][i]=num++; //Going from bottom to top
        }
        return ans;
    }
}