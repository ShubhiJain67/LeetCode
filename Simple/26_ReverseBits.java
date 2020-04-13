public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans=0;
        int i=0;
        while(i!=32){
            if((n&1)==0)
                ans=ans<<1;
            else{
                ans=ans<<1;
                ans=ans+1;                
            }
            
            n=n>>1;
            i++;
        }
        
        return ans;
    }
}