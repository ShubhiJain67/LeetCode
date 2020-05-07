class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target)
                break;
            else if(nums[mid]<target)
                i=mid+1;
            else if(nums[mid]>target)
                j=mid-1;
        }
        int [] ans=new int[2];
        if(i>j){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        while(nums[i]!=target || nums[j]!=target){
            if(nums[i]<target) i++;
            if(nums[j]>target) j--;
        }
        ans[0]=i;
        ans[1]=j;
        return ans;
    }
}