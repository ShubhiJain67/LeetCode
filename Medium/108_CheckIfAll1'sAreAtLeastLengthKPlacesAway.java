class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if(k==0 || nums.length==1)return true;
        int zeroCount=-1;
        int i=0;
        while(i<nums.length && nums[i]==0)
            i++;
        if(i==nums.length) return true;
        int j=nums.length-1;
        while(j>=0 && nums[j]==0)
            j--;
        for(;i<=j;i++){
            if(nums[i]==0)
                zeroCount++;
            else{
                 if(zeroCount<k && zeroCount!=-1) return false;
                zeroCount=0;
            }
        }
        return true;
    }
}