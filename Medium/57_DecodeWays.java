class Solution {
    public int numDecodings(String s) {
        // return decodeIterDP(s);
        // return decodeIter2Pointer(s);
        // return decodeRec(s,0);
        memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return decodeRecMemo(s,0);
    }
    private int decodeRec(String s,int i){
        if(i==s.length())
            return 1;
        if(i>s.length() || s.charAt(i)=='0')
            return 0;
        int count=decodeRec(s,i+1);
        if(i==s.length()-1)
            return count;
        int num=(s.charAt(i)-'0')*10+s.charAt(i+1)-'0';
        if(num<27)
            count+=decodeRec(s,i+2);
        return count;
    }
    int memo[];
    private int decodeRecMemo(String s,int i){
        if(i==s.length())
            return 1;
        if(i>s.length() || s.charAt(i)=='0'){
            memo[i]=0;
            return 0;
        }
        if(memo[i]!=-1)
            return memo[i];
        int count=decodeRec(s,i+1);
        if(i==s.length()-1)
            return count;
        int num=(s.charAt(i)-'0')*10+s.charAt(i+1)-'0';
        if(num<27)
            count+=decodeRec(s,i+2);
        memo[i]=count;
        return count;
    }
    private int decodeIterDP(String s){
        int len=s.length();
        int dp[]=new int[len+1];
        dp[len]=1;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
            }else{
                dp[i]=dp[i+1];
                if(i==len-1)
                    continue;
                int num=(s.charAt(i)-'0')*10+s.charAt(i+1)-'0';
                if(num<27)
                    dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
    private int decodeIter2Pointer(String s){
        int len=s.length();
        int a=(s.charAt(len-1)=='0')?0:1;
        int b=1;
        for(int i=len-2;i>=0;i--){
            int count=0;
            if(s.charAt(i)!='0'){
                count=a;
                if(i==len-1)
                    continue;
                int num=(s.charAt(i)-'0')*10+s.charAt(i+1)-'0';
                if(num<27)
                    count+=b;
            }
            b=a;
            a=count;
        }
        return a;
    }
}
