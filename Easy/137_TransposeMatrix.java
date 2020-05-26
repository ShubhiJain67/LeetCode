class Solution {
    public int[][] transpose(int[][] A) {
        if(A.length==0 || A[0].length==0) return A;
        int n=A.length;
        int m=A[0].length;
        int ans[][]=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][i]=A[i][j];
            }
        }
        return ans;
    }
}