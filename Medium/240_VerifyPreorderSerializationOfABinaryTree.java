class Solution {
    public boolean isValidSerialization(String preorder) {
        String str[]=preorder.split(",");
        int len=str.length;
        int stack[]=new int[len];
        int top=-1;
        for(int i=0;i<len;i++){
            String s=str[i];
            if(!s.equals("#"))
                stack[++top]=0;
            else
                while(top!=-1 && ++stack[top]==2)
                    top--;              
            if(i!=(len-1) && top==-1)
                return false;
        }
        return top==-1;        
    }
}