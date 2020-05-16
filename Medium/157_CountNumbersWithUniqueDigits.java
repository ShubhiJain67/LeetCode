class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if(n==1) return 10;
        if (n > 10) n=10;
        int cnt = 10;
        for (int i = 2; i <= n; i ++){
            int m = 9;
            for (int j = 1; j < i; j++){
                m *= (10 - j);
            }
            cnt += m;
        }
        return cnt;
    }
}
