class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans=0;
        int hashset[]=new int[100];
        for(int [] d : dominoes){
            int hash=d[0]*10+d[1];
            if(d[0]>d[1]){
                hash=d[1]*10+d[0];
            }
            ans=ans+hashset[hash];
            hashset[hash]++;
        }
        return ans;
    }
}