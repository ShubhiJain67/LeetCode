class Solution {
    public void sortColors(int[] nums) {
        int red=0;
        int white=0;
        int blue=0;
        for(int n:nums){
            if(n==0) red++;
            if(n==1) white++;
            if(n==2) blue++;
        }
        int i=0;
        for(i=0;i<red;i++){
            nums[i]=0;
        }
        for(int j=0;j<white;j++){
            nums[i++]=1;
        }
        for(int j=0;j<blue;j++){
            nums[i++]=2;
        }
    }
}