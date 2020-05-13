class Solution {
    public int minStartValue(int[] nums) {
        int result = 0;
        int currentSum =0;
        for(int i =0;i<nums.length;i++){
            currentSum+=nums[i];
            if(currentSum<0)
            result = Math.min(result,currentSum);
        }
        return Math.abs(result)+1;
    }
}