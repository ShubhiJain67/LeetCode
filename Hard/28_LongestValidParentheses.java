class Solution {
    public int longestValidParentheses(String s) {
        int len=s.length();
        boolean visited[]=new boolean[len];
        int stack[]=new int[len];
        int top=-1;
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch=='(')
                stack[++top]=i;
            else{
                if(top!=-1){
                    visited[stack[top]]=true;
                    visited[i]=true;
                    top--;
                }
            }
        }
        int max=0,curr=0;
        for(boolean b:visited){
            if(b)
                curr++;
            else{
                max=Math.max(max,curr);
                curr=0;
            }
        }
        return Math.max(max,curr);
    }
}