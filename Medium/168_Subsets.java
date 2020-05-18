class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        subset(ans,new ArrayList<>(),nums,0);
        return ans;
    }
    public void subset(List<List<Integer>> ans,List<Integer> temp,int []nums,int start){
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            List<Integer> tempList=new ArrayList<>();
            tempList.addAll(temp);
            ans.add(tempList);
            subset(ans,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
