class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a: A)
            if (a % 2 == 0)
                sum += a;
        int len=queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; ++i) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0)  
                sum -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) 
                sum += A[index];
            ans[i] = sum;
        }

        return ans;
    }
}