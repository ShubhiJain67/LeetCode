class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length) return -1;
        
        for(int i=0;i<k;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    nums[i]+=nums[j];
                    nums[j]=nums[i]-nums[j];
                    nums[i]-=nums[j];
                }
            }
        }
        // System.out.println(nums[0]+" "+nums[1]);
        return nums[k-1];
    }
}
