class Solution {
    public int minDistance(String word1, String word2) {
        memo=new int[word1.length()+1][word2.length()+1];
        return minDP(word1,word2,word1.length(),word2.length());
    }
    // TLE
    private int minRecursive(String w1,String w2,int len1,int len2){
        if(len1==0)
            return len2;
        if(len2==0)
            return len1;
        if(w1.charAt(len1-1)==w2.charAt(len2-1))
            return minRecursive(w1,w2,len1-1,len2-1);
        int insert=minRecursive(w1,w2,len1,len2-1);
        int delete=minRecursive(w1,w2,len1-1,len2);
        int replace=minRecursive(w1,w2,len1-1,len2-1);
        return 1+Math.min(insert,Math.min(delete,replace));
    }
    // 3ms 99.68%
    private int memo[][];
    private int minMemo(String w1,String w2,int len1,int len2){
        if(len1==0)
            return len2;
        if(len2==0)
            return len1;
        if(memo[len1][len2]!=-0)
            return memo[len1][len2];
        if(w1.charAt(len1-1)==w2.charAt(len2-1)){
            memo[len1][len2]=minMemo(w1,w2,len1-1,len2-1);
        }
        else{
            int insert=minMemo(w1,w2,len1,len2-1);
            int delete=minMemo(w1,w2,len1-1,len2);
            int replace=minMemo(w1,w2,len1-1,len2-1);
            memo[len1][len2]=1+Math.min(insert,Math.min(delete,replace));
        }
        return memo[len1][len2];
    }
    // 8ms 19.28%
    private int minDP(String w1,String w2,int len1,int len2){
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else if(w1.charAt(i-1)==w2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[len1][len2];
    }
}