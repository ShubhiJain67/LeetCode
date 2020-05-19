class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int i=0;
        int len=nums.length;
        while(i<len){
            if(nums[i]==0){
                i++;
                continue;
            }
            int count=0;
            while(i<len && nums[i]==1){
                count++;
                i++;
            }
            if(maxCount<count)
                maxCount=count;
        }
        return maxCount;
    }
}