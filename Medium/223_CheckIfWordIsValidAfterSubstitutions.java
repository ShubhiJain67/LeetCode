class Solution {
    public static class Stack{
        char stack[];
        int top;
        Stack(String str){
            this.stack=new char[str.length()];
            this.top=0;
        }
        void push(char ch){
            stack[top++]=ch;
        }
        char pop(){
            return stack[top--];             
        }
        boolean isEmpty(){
            return top==0;
        }
        char top(){
            return stack[top-1];
        }
    }
    public boolean isValid(String S) {
        Stack stack=new Stack(S);
        for(char ch: S.toCharArray()){
            if(ch=='a')
                stack.push('a');
            else if(ch=='b'){
                if(stack.isEmpty() || stack.top()!='a')
                    return false;
                else{
                    stack.pop();
                    stack.push('b');
                }
            }
            else{
                if(stack.isEmpty() || stack.top()!='b')
                    return false;
                else
                    stack.pop();
            }
            
        }
        return stack.isEmpty();
    }
}