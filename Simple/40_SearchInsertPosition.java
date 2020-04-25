class Solution {
    public int searchInsert(int[] nums, int target) {
        int lower=0,upper=nums.length-1,mid=0;
        while(lower<=upper){
            mid=(lower+upper)/2;
            // System.out.println(mid);
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) upper=mid-1;
            else lower=mid+1;
        }
        
        if(nums[mid]>target) return mid;
        else return mid+1;
    }
}