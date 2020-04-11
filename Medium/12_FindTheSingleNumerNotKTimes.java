import java.util.*;
class FindTheSingleNumer {
    public static void main(String args[]){
        int []nums={1,2,3,4,5,1,2,3,4,5,6};
        int k=2;
        System.out.println(singleNumber(nums,k));
    }

    public static  int singleNumber(int[] nums,int k) {
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            int mask=(1<<i);
            for(int num:nums){
                if((num & mask)!=0){
                    count++;
                }
            }
            if(count%k!=0){
                ans=ans+(1<<i);
            }
        }
        return ans;
    }
}