class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='[' || c=='{' || c=='(') stack.push(c);
            else{
                if(stack.empty()) return false;
                char p=stack.pop();
                if(c==']'){
                    if(p!='[') return false;
                }
                if(c=='}'){
                    if(p!='{') return false;
               }
                if(c==')'){
                    if(p!='(') return false;
                }
            }
        }
        if(stack.empty()) return true;
        else return false;
    }
}
