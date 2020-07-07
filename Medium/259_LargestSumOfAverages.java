class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n=A.length;
        dp=new double[n][K+1];
        sum=new double[n][n];
        for(int d=0;d<n;d++){
            for(int j=0;j+d<n;j++){
                if(d==0)
                   sum[j][j]=A[j];
                else
                    sum[j][j+d]=sum[j+1][j+d]+sum[j][j+d-1]-sum[j+1][j+d-1];
            }
        }
        double ret=get(A,0,n-1,K);
        return ret;
    }
    double dp[][],sum[][];
    private double get(int A[],int s,int n,int k){
        if(s>n || n-s+1<k)
            return 0;
        if(dp[s][k]!=0)
            return dp[s][k];
        if(k==1){
            dp[s][k]= sum[s][n]/(n-s+1);
            return dp[s][k];
        }
        double max=0;
        for(int i=s;i<n;i++){
            double res=get(A,i+1,n,k-1);
            max=Math.max(sum[s][i]/(i-s+1)+res,max);
        }
        dp[s][k]=max;
        return dp[s][k];
    }
}