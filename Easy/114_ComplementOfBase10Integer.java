class Solution {
    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        int mask=1;
        while(mask<=N){
            mask=mask<<1;
        }
        return mask-N-1;
    }
}