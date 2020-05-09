class Solution {
    public int minFlips(int a, int b, int c) {
        int cc=(a|b);
        int mask=1;
        int flip=0;
        for(int i=0;i<32;i++){
            int cm=(c&mask);
            int ccm=(cc&mask);
            int am=(a&mask);
            int bm=(b&mask);
            if(cm!=ccm){
                if(ccm==0){
                    flip++;
                }else{
                    if(am!=0)
                        flip++;
                    if(bm!=0)
                        flip++;
                }
            }
            mask=(mask<<1);
        }        
        return flip;
    }
}