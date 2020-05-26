class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String str="";
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                if(str!=""){
                    ans=ans+str+" ";
                    str="";
                }
            }else{
                str=ch+str;
            }
        }
        return ans+str;
    }
}