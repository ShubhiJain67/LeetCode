class Solution {
    public int sumBase(int n, int k) {
        return Approach1(n, k);
    }
    public int Approach1(int n, int k){
        int sum = 0;
        while(n > 0){
            //System.out.println(n);
            sum += n % k;
            n = n / k;
        }
        return sum;
    }
    public int Approach2(int n,int k){
        if(n <= 0){
            return 0;
        }
        return n % k + Approach2(n / k, k);
    }
}