class Solution {
    public String simplifyPath(String path) {
        int count=1;
        Stack<String> stack=new Stack<>();
        for(String s:path.split("/")){
            // System.out.println(count++ +" "+s+" "+s.length());
            int len=s.length();
            if(len>0){
                if(len==1 && s.charAt(0)=='.')
                    continue;
                else if(len==2 && s.charAt(0)=='.' && s.charAt(1)=='.'){
                    if(stack.size()!=0)
                        stack.pop();
                }
                else
                    stack.push(s);
            }
        }
        if(stack.size()==0)
            return "/";
        String str="";
        while(stack.size()!=0){
            str="/"+stack.pop()+str;
        }
        return str;
    }
}