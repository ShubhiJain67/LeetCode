class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        String startAns="", midAns="" ,endAns="";
        int i=0,endi=s.length()-1;
        
        // Get before 1st (
        while(i!=s.length() && s.charAt(i)!='('){
            startAns+=s.charAt(i);
            i++;
        }
        // System.out.println(startAns);
        
        // If No bracket
        if(i==s.length()){
            return startAns;
        }
        
        // Get after last )
        while(endi!=-1 && s.charAt(endi)!=')'){
            endAns=s.charAt(endi)+endAns;
            endi--;
        }
        // System.out.println(endAns+" "+endi);
        
        // Remove after last )
        s=s.substring(0,endi+1);
        // System.out.println(s+" "+i+" "+s.length());
        
        // Insert all before 1st )
        while(i!=s.length() && s.charAt(i)!=')'){
            stack.push(s.charAt(i));
            i++;
        }
        // System.out.println(i);
        
        // if only 1 bracket
        if(i==s.length()-1){
            char ch=stack.pop();
            String a="";
            while(stack.isEmpty()!=true && ch!='('){
                a=a+ch;
                ch=stack.pop();
            }
            
            return startAns+a+endAns;
        }
        
        
        while(i!=s.length()){
            if(s.charAt(i)==')'){
                String str="";
                char c=stack.pop();
                while(stack.isEmpty()!=true && c!='('){
                    str=str+c;
                    c=stack.pop();
                }
                int j=0;
                while(j!=str.length()){
                    stack.push(str.charAt(j));
                    j++;
                }
                // System.out.println(c);
            }
            else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        while(stack.isEmpty()!=true){
            midAns=stack.pop()+midAns;
        }
        
        return startAns+midAns+endAns;
    }
}