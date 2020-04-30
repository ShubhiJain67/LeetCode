class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length==0) return new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            nums[i]=count;
        }
        nums[nums.length-1]=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int n:nums){
            ans.add(n);
        }
        return ans;
    }
}