class Solution {
    public int lengthOfLIS(int[] arr) {
        int ans=0,n=arr.length,dp[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i])
                    dp[i]=Math.max(dp[j],dp[i]);
            }
            dp[i]++;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}