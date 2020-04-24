class Solution {
    public int minSteps(int n) {
        int sum=0;
        while(n>1){
            if(n%2==0){
                sum=sum+2;
                n=n/2;
            }
            else if(isPrime(n)){
                sum=sum+n;
                n=n/n;
            }else{
                int m=findFactor(n);
                sum=sum+(n/m);
                n=m;
            }
        }
        return sum;
    }
    public boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int findFactor(int n){
        for(int i=n/2;i>2;i--){
            if(n%i==0) return i;
        }
        return n;
    }
}