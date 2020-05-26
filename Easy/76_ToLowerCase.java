class Solution {
    public String toLowerCase(String str) {
        String ans="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='A' && ch<='Z')
                ch=(char)('a'+(ch-'A'));
            ans=ans+ch;
        }
        return ans;
    }
}