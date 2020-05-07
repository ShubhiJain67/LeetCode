class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){

            if(first == Integer.MAX_VALUE || nums[i] <= first){
                first = nums[i];
                continue;
            }else if(first < nums[i]){
                if(second == Integer.MAX_VALUE || nums[i] <= second){
                    second = nums[i];
                }else if(nums[i] >second){
                    return true;
                }
            }
        }
        return false;
    }
}