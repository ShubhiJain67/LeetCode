class Solution {
    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        Arrays.fill(ret, Integer.MAX_VALUE);
        ret[0] = 0;
        ret[1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                ret[i] = Math.min(ret[i - j * j] + 1, ret[i]);
            }
        }
        return ret[n];
    }
}