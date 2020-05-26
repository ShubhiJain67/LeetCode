class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int a = 1; a <= A.length; a++) {
            for (int b = 1; b <= B.length; b++) {
                if (A[a - 1] == B[b - 1]) {
                    dp[a][b] = dp[a - 1][b - 1] + 1;
                } else {
                    dp[a][b] = Math.max(dp[a][b - 1], dp[a - 1][b]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}