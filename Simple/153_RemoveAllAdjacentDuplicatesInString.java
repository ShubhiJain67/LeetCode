class Solution {
    public String removeDuplicates(String S) {
        int len=S.length();
        char stack[]=new char[len];
        int index=-1;
        for(int i=0;i<len;i++){
            char ch=S.charAt(i);
            if(index==-1 || stack[index]!=ch){
                stack[++index]=ch;
            }else
                stack[index--]='.';
        }
        String ans="";
        for(int i=0;i<=index;i++){
            char ch=stack[i];
            if(ch!='.')
                ans+=ch+"";
        }
        return ans;
    }
}