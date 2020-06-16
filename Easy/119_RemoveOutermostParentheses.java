class Solution {
    public String removeOuterParentheses(String S) {
        int len=S.length();
        int top=0;
        String ans="";
        for(int i=0;i<len;i++){
            char ch=S.charAt(i);
            if(ch=='('){
                top++;
                if(top!=1)
                    ans=ans+"(";
            }else{
                if(top!=1)
                   ans=ans+")"; 
                top--;
            }
        }
        return ans;
    }
}
