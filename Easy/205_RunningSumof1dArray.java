class Solution {
    public int[] runningSum(int[] nums) {
        int len=nums.length;
        if(len==0 || len==1)
            return nums;
        int [] ans=new int[len];
        ans[0]=nums[0];
        for(int i=1;i<len;i++){
            ans[i]=nums[i]+ans[i-1];
        }
        return ans;
    }
}