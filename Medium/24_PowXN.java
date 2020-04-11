class Solution {
    public double myPow(double x,int n){
        double ans;
        if(n<0) {
            ans=my(x,n*-1);
            return (1/ans);
        }
        return my(x,n);
    }
    public double my(double x, int n) {
        if(n==0) {
            return 1;
        }
        if(n==1){
            return x;
        }
        double half=my(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
}