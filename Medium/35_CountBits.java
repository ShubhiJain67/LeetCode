class Solution {
    public int[] countBits(int n) {
        int [] ans=new int[n+1];
        ans[0]=0;
        int num=0;
        int nextnum=1;
        for(int i=1;i<=n;i++){
            if(i==nextnum){
                num=nextnum;
                nextnum=nextnum<<1;
            }
            ans[i]=ans[i-num]+1;
        }
        return ans;
    }
}