class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=2) return false;
        int sum=0;
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                sum+=i;
                sum+=(num/i);
            }
        }
        sum++;
        return sum==num;
    }
}