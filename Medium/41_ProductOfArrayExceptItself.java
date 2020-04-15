class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int [] ar=new int[len];
        for(int i=0;i<len;i++){
            ar[i]=1;
        }
        int left=1;
        int right=1;
        for(int i=0;i<len;i++){
            ar[i]=ar[i]*left;
            left=left*nums[i];
        }
        for(int i=len-1;i>=0;i--){
            ar[i]=ar[i]*right;
            right=right*nums[i];
        }
        return ar;
        
    }
}