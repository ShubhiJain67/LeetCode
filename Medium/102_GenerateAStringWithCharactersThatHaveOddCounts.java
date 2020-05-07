class Solution {
    public String generateTheString(int n) {
        String ans="";
        char ch='b';
        if((n&1)==0 && n-->0)  ans+=ch;
        ch='a';
        while(n--!=0)   ans=ch+ans;
        return ans;
    }
}