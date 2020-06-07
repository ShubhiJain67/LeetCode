public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        
        dp[0][0] = 1;
        for (int i = 1; i < amount + 1; ++i) {
            dp[i][0] = 0;
        }
        
        for (int j = 1; j < coins.length + 1; ++j) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < amount + 1; ++i) {
            for (int j = 1; j < coins.length + 1; ++j) {
                dp[i][j] = dp[i][j - 1];
                
                if (coins[j - 1] <= i) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }
        
        return dp[amount][coins.length];
    }
}