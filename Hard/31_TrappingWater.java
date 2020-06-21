class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int stack[]=new int[len];
        int top=-1;
        int ans=0;
        for(int i=0;i<len;i++){
            while(top!=-1 && height[stack[top]]<height[i]){
                int pop=stack[top];
                top--;
                if(top==-1)
                    break;
                if(height[stack[top]]>height[i])
                    ans+=(i-stack[top]-1)*(height[i]-height[pop]);
                else
                    ans+=(i-stack[top]-1)*(height[stack[top]]-height[pop]);                
            }
            stack[++top]=i;
        }
        return ans;
    }
}