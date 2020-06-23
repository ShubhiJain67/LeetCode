class Solution {
    int dp[];
    public int climbStairs(int n) {
        // dp=new int[n+1];
        int ans=optimizedSol(0,n);
        return ans;
    }
    private int recSol(int cur,int n){
        if(cur>n) return 0;
        if(cur==n){
            dp[cur]=1;
            return 1;
        }
        if(dp[cur]!=0) return dp[cur];
        dp[cur]=recSol(cur+1,n)+recSol(cur+2,n);
        return dp[cur];
    }
    private int iterSol(int cur,int n){
        for(int i=0;i<=n;i++){
            if(i==0 || i==1)
                dp[i]=1;
            else
                dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[cur];
    }
    private int optimizedSol(int cur,int n){
        if(n==0 || n==1) return 1;
        int a=1,b=1,sum=a+b;
        for(int i=2;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
