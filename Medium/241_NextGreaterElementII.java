public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int stack[]=new int[len];
        int ans[]=new int[len];
        int top=-1;
        Arrays.fill(ans,-1);
        for(int i=0;i<len;i++){
            int curr=nums[i];
            while(top!=-1 && nums[stack[top]]<curr)
                ans[stack[top--]]=curr;
            stack[++top]=i;
        }
        for(int i=0;i<len;i++){
            int curr=nums[i];
            while(top!=-1 && nums[stack[top]]<curr)
                ans[stack[top--]]=curr;
        }
        return ans;
    }
}