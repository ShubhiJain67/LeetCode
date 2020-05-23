class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String t:tokens){
            char ch=t.charAt(0);
            if(t.length()==1 && (ch=='+' || ch=='-' || ch=='/' || ch=='*')){
                int num1=stack.pop();
                int num2=stack.pop();
                int ans=0;
                if(ch=='+')
                    ans=num2+num1;
                else if(ch=='-')
                    ans=num2-num1;
                else if(ch=='*')
                    ans=num2*num1;
                else
                    ans=num2/num1;
                stack.push(ans);
            }
            else{
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}