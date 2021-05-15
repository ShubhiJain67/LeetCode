class Solution {
    public int countPrimeSetBits(int L, int R) {
        int num=0;
        int nextnum=1;
        int [] arr=new int[R+1];
        for(int i=1;i<=R;i++){
            if(i==nextnum){
                num=nextnum;
                nextnum=nextnum<<1;
            }
            arr[i]=arr[i-num]+1;
        }
        int count=0;
        for(int i=L;i<=R;i++){
            if( arr[i]==2 || arr[i]==3 || arr[i]==5 || arr[i]==7 || arr[i]==11 || arr[i]==13 || arr[i]==17 || arr[i]==19 || arr[i]==23 || arr[i]==29 || arr[i]==31 ){
                count++;
            }
        }
        return count;
    }
}