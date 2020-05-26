class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack=new Stack<>();
        String ans="";
        int i=0;
        while(i<S.length()){
            stack.push('*');
            i++;
            String str="";
            while(i<S.length() && stack.size()!=0){
                int ch=S.charAt(i++);
                if(ch=='('){
                    stack.push('(');
                    str=str+"(";
                }
                else{
                    if(stack.peek()!='*')
                        str=str+")";
                    stack.pop();
                }
            }
            ans=ans+str;
        }
        return ans;
    }
}