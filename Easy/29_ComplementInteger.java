class Solution {
    public int findComplement(int num) {
        if(num==0)return 1;
        int n=0;
        int mask=1;
        while(num!=0){
            if((num&1)==0){
                n=n+mask;
                mask=mask<<1;
            }
            else{
                mask=mask<<1;
            }
            num=num>>>1;
        }
        return n;
    }
}