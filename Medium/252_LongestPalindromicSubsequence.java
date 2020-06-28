class Solution {
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()][s.length()];
        return longestIter(s);
    }
    int dp[][];
    private int longest(String s,int i,int j){
        if(i>j)
            return 0;
        if(i==j)
            return 1;
        if(dp[i][j]!=0)
            return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
            return longest(s,i+1,j-1)+2;
        int left=longest(s,i+1,j);
        int right=longest(s,i,j-1);
        dp[i][j]=Math.max(left,right);
        return dp[i][j];
    }
    private int longestIter(String str){
        int max=0,n=str.length();
        for(int gap=0;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                if(gap==0 || (gap==1 && str.charAt(i)==str.charAt(i+1))){
                    dp[i][i+gap]=gap+1;
                    if(max<dp[i][i+gap]){
                        max=dp[i][i+gap];
                    }
                }
                else if(str.charAt(i)==str.charAt(i+gap) && dp[i+1][i+gap-1]!=0)
                    dp[i][i+gap]=2+dp[i+1][i+gap-1];
                else
                    dp[i][i+gap]=dp[i+1][i+gap]>dp[i][i+gap-1]?dp[i+1][i+gap]:dp[i][i+gap-1];
                if(max<dp[i][i+gap]){
                    max=dp[i][i+gap];
                }
            }
        }
        return max;
    }
}