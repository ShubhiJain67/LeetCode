class Solution {
    public int findLength(int[] A, int[] B) {
        int dp[][]=new int[A.length][B.length],max=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]!=B[j])
                    dp[i][j]=0;
                else{
                    if(i-1>=0 && j-1>=0)
                        dp[i][j]=dp[i-1][j-1];
                    dp[i][j]+=1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}