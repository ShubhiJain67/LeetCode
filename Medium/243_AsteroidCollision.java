class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int stack[]=new int[asteroids.length];
        int top=-1;
        for(int i:asteroids){
            if(i>0)
                stack[++top]=i;
            else{
                while(top!=-1 && stack[top]>0 && stack[top]< -i)
                    top--;
                if(top!=-1 && stack[top]==-i)
                    top--;
                else if(top==-1 || stack[top]<0)
                    stack[++top]=i;
            }
        }
        int ans[]=new int[top+1];
        for(int i=0;i<=top;i++){
            ans[i]=stack[i];
        }
        return ans;
    }
}