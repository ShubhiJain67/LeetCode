class Solution {
    public String decodeString(String s) {
        int len=s.length();
        String stack[]=new String[len];
        int top=-1;
        String num="";
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch=='['){
                stack[++top]=(num=="")?"0":num;
                stack[++top]="[]";
                num="";
                stack[++top]="[";
            }else if(ch>='0' && ch<='9')
                num=num+ch;
            else if(ch==']'){
                String temp="";
                while(stack[top].compareTo("[]")!=0){
                    if(stack[top].compareTo("[")!=0) 
                        temp=stack[top]+temp;
                    top--;
                }
                int n=Integer.valueOf(stack[--top]);
                String put="";
                while(n--!=0)
                    put=put+temp;
                stack[top]=put;
            }else
                stack[++top]=ch+"";
        }
        String ans="";
        while(top!=-1)
            ans=stack[top--]+ans;
        return ans;
    }
}