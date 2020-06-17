class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int a:A)
            sum+=a;
        if(sum%3!=0)
            return false;
        int req=sum/3;
        int currsum=0;
        int count=0;
        for(int a:A){
            currsum+=a;
            if(currsum==req){
                count++;
                currsum=0;
            }
        }
        return currsum==0 && count>=3;
    }
}