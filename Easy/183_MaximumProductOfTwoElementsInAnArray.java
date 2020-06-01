class Solution {
    public int maxProduct(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[j]>nums[i]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            j++;
        }
        j=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[j]>nums[i]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            j++;
        }
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}