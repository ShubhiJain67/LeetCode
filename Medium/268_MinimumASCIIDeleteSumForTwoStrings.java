class Solution {
    public int minimumDeleteSum(String w1, String w2) {
        int len1=w1.length();
        int len2=w2.length();
        arr1=new int[len1];
        arr2=new int[len2];
        for(int i=0;i<len1;i++){
            arr1[i]=w1.charAt(i);
            if(i>0)
                arr1[i]+=arr1[i-1];
        }
        for(int i=0;i<len2;i++){
            arr2[i]=w2.charAt(i);
            if(i>0)
                arr2[i]+=arr2[i-1];
        }
        // memo=new int[len1+1][len2+1];
        return minDP(w1,w2,len1,len2);
    }
    // TLE
    int arr1[],arr2[];
    private int minRec(String w1,String w2,int len1,int len2){
        if(len1==0)
            return len2==0?0:arr2[len2-1];
        if(len2==0)
            return len1==0?0:arr1[len1-1];
        if(w1.charAt(len1-1)==w2.charAt(len2-1))
            return minRec(w1,w2,len1-1,len2-1);
        int del1=w1.charAt(len1-1)+minRec(w1,w2,len1-1,len2);
        int del2=w2.charAt(len2-1)+minRec(w1,w2,len1,len2-1);
        return Math.min(del1,del2);
    }
    // 36ms 23.15%
    private int memo[][];
    private int minMemo(String w1,String w2,int len1,int len2){
        if(len1==0)
            return len2==0?0:arr2[len2-1];
        if(len2==0)
            return len1==0?0:arr1[len1-1];
        if(memo[len1][len2]!=0)
            return memo[len1][len2];
        if(w1.charAt(len1-1)==w2.charAt(len2-1))
            memo[len1][len2]=minMemo(w1,w2,len1-1,len2-1);
        else{
            int del1=w1.charAt(len1-1)+minMemo(w1,w2,len1-1,len2);
            int del2=w2.charAt(len2-1)+minMemo(w1,w2,len1,len2-1);
            memo[len1][len2]=Math.min(del1,del2);
        }
        return memo[len1][len2];
    }
    //18ms 75.72%
    private int minDP(String w1,String w2,int len1,int len2){
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0)
                    dp[i][j]=j==0?0:arr2[j-1];
                else if(j==0)
                    dp[i][j]=i==0?0:arr1[i-1];
                else if(w1.charAt(i-1)==w2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    int del1=w1.charAt(i-1)+dp[i-1][j];
                    int del2=w2.charAt(j-1)+dp[i][j-1];
                    dp[i][j]=Math.min(del1,del2);
                }
            }
        }
        return dp[len1][len2];
    }
}