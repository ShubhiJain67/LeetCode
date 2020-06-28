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
}