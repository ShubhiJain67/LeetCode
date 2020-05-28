class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len=nums.length;
        if(len==0 || len==1)
            return len;
        int ans=0,count=1;
        for(int i=1;i<len;i++){
            if(nums[i]<=nums[i-1])
                count=0;
            count++;
            if(ans<count)
                ans=count;
        }
        return ans;
    }
}