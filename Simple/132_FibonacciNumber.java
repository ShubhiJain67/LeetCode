class Solution {
    public int fib(int N) {
        if(N==0 || N==1) return N;
        int a=0;
        int b=1;
        N--;
        while(N!=0){
            b=a+b;
            a=b-a;
            N--;
        }
        return b;
    }
}