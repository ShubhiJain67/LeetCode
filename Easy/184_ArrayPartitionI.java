class Solution {
    public int arrayPairSum(int[] nums) {
        CountingSort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }
    private void CountingSort(int [] nums){
        int count[]=new int[20001];
        for(int i:nums){
            count[i+10000]++;
        }
        int i=0;
        int c=0;
        while(i<nums.length){
            while(count[c]!=0){
                nums[i++]=c-10000;
                count[c]--;
            }
            c++;
        }
    }
}