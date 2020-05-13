class Solution {
    public int[] getNoZeroIntegers(int n) {
        n--;
        int m=1;
        int ans[]={m,n};
        
        while(contains(ans[0])==true || contains(ans[1])==true){
            ans[0]++;
            ans[1]--;
        }
        
        return ans;
    }
    public boolean contains(int n){
        boolean flag=false;
        while(n!=0){
            if(n%10==0)
                return true;
            n=n/10;
        }
        return false;
    }
}