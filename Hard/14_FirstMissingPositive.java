class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==1) return nums[0]==1?2:1;
        String ans="";
        int max=0;
        for(int num:nums){
            if(num<nums.length+2 && max<num){
                max=num;
            }
        }
        if(max==0) return 1;
        for(int i=1;i<max;i++)    ans=ans+"0";
        ans=ans+"1";
        for(int num:nums){
            if(num<nums.length+2 && num>0){
                ans=ans.substring(0,num-1)+"1"+ans.substring(num);
            }
        }
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='0'){
                return i+1;
            }
        }
        return ans.length()+1;
    }
}