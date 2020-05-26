class Solution {
    public int[] sumZero(int n) {
        int [] ans=new int[n];
        if(n%2==1){
            ans[0]=0;
            n--;
        }
        int num=1;
        while(n!=0){
            ans[--n]=num*-1;
            ans[--n]=num;
            num++;
        }
        return ans;
    }
}