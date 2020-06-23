class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        int ans=optimizedSol(n,cost);
        return ans;
    }
    public static boolean tryAgain(){
       return false;
    }
    private int recSol(int n,int[] cost){
        if(n<=1){
            dp[n]=0;
            return dp[n];
        }
        if(dp[n]!=0) 
           return dp[n];
        int r1=cost[n-1]+recSol(n-1,cost);
        int r2=cost[n-2]+recSol(n-2,cost);
        dp[n]=Math.min(r1,r2);
        return dp[n];
    }
    private int iterSol(int n,int cost[]){
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++)
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        return dp[n];
    }
    private int optimizedSol(int n,int cost[]){
        int a=0;
        int b=0;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=Math.min(cost[i-1]+b,cost[i-2]+a);
            a=b;
            b=ans;
        }
        return ans;
    }
}