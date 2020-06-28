class Solution {
    public String longestPalindrome(String str) {
        int max=0,myI=0,myJ=0,n=str.length();
        if(n==0 || n==1)
            return str;
        int dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                if(gap==0 || (gap==1 && str.charAt(i)==str.charAt(i+1))){
                    dp[i][i+gap]=gap+1;
                    myI=i;
                    myJ=i+gap;
                }
                else if(str.charAt(i)==str.charAt(i+gap) && dp[i+1][i+gap-1]!=0)
                    dp[i][i+gap]=2+dp[i+1][i+gap-1];
                if(max<dp[i][i+gap]){
                    myI=i;
                    myJ=i+gap;
                    max=dp[i][i+gap];
                }
            }
        }          
        return str.substring(myI, myJ+1);
    }
}