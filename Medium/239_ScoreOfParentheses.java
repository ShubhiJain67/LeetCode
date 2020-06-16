class Solution {
    public int scoreOfParentheses(String S) {
        int len=S.length();
        int top=-1;
        int stack[]=new int[len/2];
        for(int i=0;i<len;i++){
            char ch=S.charAt(i);
            // System.out.println(ch+" "+i);
            if(ch=='('){
                stack[++top]=Integer.MIN_VALUE;
                // System.out.println("Pushing Min at : "+top);
            }
            else{
                int sum=0;
                while(stack[top]!=Integer.MIN_VALUE){
                    sum+=stack[top];
                    // System.out.println("Popped : "+stack[top]+" from :"+top+" now the sum is : "+sum);
                    top--;
                }
                // System.out.println("Pushing : "+((sum==0)?1:sum*2)+" at "+top);
                stack[top]=sum==0?1:sum*2;
            }
        }
        int ans=0;
        while(top!=-1){
            ans+=stack[top];
            top--;
        }
        return ans;
    }
}