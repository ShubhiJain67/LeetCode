class Solution {
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int ret=(nums[i]^nums[j]);
                if(max<ret)
                    max=ret;
            }
        }
        return max;
    }
}