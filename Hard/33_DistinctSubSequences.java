class Solution {
    public int numDistinct(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        for(int [] d: dp)
            Arrays.fill(d,-1);
        return max(s,t,s.length(),t.length());
    }
    int dp[][];
    private int max(String s,String t,int si,int ti){
        if(ti==0)   return 1;
        if(si<ti)   return 0;
        if(dp[si][ti]!=-1)  return dp[si][ti];
        dp[si][ti]=max(s,t,si-1,ti);
        if(s.charAt(si-1)==t.charAt(ti-1))  dp[si][ti]+=max(s,t,si-1,ti-1); 
        return dp[si][ti];        
    }
    private int maxIter(String s,String t,int si,int ti){
        if(ti-t.length()==0)
            return 1;
        if(s.length()-si)
        dp[si][ti]=max(s,t,si+1,ti);
        if(s.charAt(si)==t.charAt(ti))
            dp[si][ti]+=max(s,t,si+1,ti+1); 
        return dp[si][ti];
    }
    private int maxDP(String s,String t){
        int n=s.length(),m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int si=n;si>=0;si--){
            for(int ti=m;ti>=0;ti--){
                if(ti==t.length()){
                    dp[si][ti]=1;
                    continue;
                }
                if(s.length()-si < t.length()-ti || si>=s.length() || ti>=t.length()){
                    dp[si][ti]=0;
                    continue;
                }
                dp[si][ti]=dp[si+1][ti];
                if(s.charAt(si)==t.charAt(ti))
                    dp[si][ti]+=dp[si+1][ti+1];
            }
        }
        
        return dp[0][0];
    }
}
