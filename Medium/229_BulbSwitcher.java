class Solution {
    public int bulbSwitch(int n) {
        int count=0;
        int num=1;
        while(num*num<=n){
            count++;
            num++;
        }
        return count;
    }
}