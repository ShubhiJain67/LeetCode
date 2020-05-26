class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int num:nums){
            while(num!=0){
                if(num/10==0)
                    break;
                num=num/100;
            }
            if(num==0) ans++;
        }
        return ans;
    }
    
}