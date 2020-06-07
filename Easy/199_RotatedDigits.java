class Solution {       
    public int rotatedDigits(int N) {
        int[] validTable= {0,0,1,-1,-1,1,1,-1,0,1};
        int res = 0;
        for(int i=2; i<=N; i++) {
            if(isGoodNumber(validTable,i)) res++;            
        }
        return res;
    }
    
    private boolean isGoodNumber(int[] validTable,int num) {
        boolean isDifferent = false;
        while(num>0){
            int digit = num%10;
            if(validTable[digit]==-1) return false;
            else if (validTable[digit]==1) isDifferent=true;
            num/=10;
        }
        return isDifferent;
    }
    
}