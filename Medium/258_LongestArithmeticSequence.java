class Solution {
    public int longestArithSeqLength(int[] A) {
        int n=A.length;
        int ans=0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i=0;i<n;i++) {
            dp[i]=new HashMap<Integer, Integer>();
        }
        for (int i=1;i<n;++i) {
            for (int j=i-1;j>=0;j--) {
                int d = A[i]-A[j];
                int len=2;  
                if (dp[j].containsKey(d)) {
                    len=dp[j].get(d)+1;
                }
                int curr=dp[i].getOrDefault(d, 0);
                dp[i].put(d,Math.max(curr, len));
                ans= Math.max(ans,dp[i].get(d));
            }
        }
        
        return ans;
    }
}