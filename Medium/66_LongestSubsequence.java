class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
         int m = s1.length();
        int n = s2.length();
        if(s1 == null || s2 == null || m == 0 || n == 0)
            return 0;
        int lcs[][] = new int[m+1][n+1];
        for(int i = 1 ; i<=m; i++){
            for(int j = 1 ; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                else
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]); // or we have to take max with right element and top element
            }
        }
        for(int i = 1 ; i<=m; i++){
            for(int j = 1 ; j<=n; j++){
                System.out.print(lcs[i][j]+" ");
            }
            System.out.println();
        }
        return lcs[m][n];
    }
}