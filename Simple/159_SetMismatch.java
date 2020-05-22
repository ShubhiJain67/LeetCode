class Solution {
    public int[] findErrorNums(int[] nums) {
        int len=nums.length;
        int [] arr=new int [len+1];
        int ans[]=new int[2];
        for(int n:nums){
            if(arr[n]==0)
                arr[n]=n;
            else
                ans[0]=n;
        }
        for(int i=1;i<=len;i++){
            if(arr[i]==0){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}