class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int newLength = len;
        int indexToReplace = len - 1;
        if(len > 0){
            for(int curr = 0; curr < len && indexToReplace >= curr; curr++){
                if(nums[curr] == val){
                    newLength--;
                    nums[curr] = nums[indexToReplace];
                    nums[indexToReplace] = val;
                    indexToReplace--;
                    curr--;
                }
            }
        }
        return newLength;
    }
}