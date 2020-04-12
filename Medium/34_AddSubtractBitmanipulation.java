class Solution {
    public int getSum(int a, int b) {
        int ans=0;
        if(a>=0 && b>=0)
            ans=Sum(a,b);
        else if(a>=0 && b<0)
            ans=Subtract(a,-b);
        else if(a<0 && b>=0)
            ans=Subtract(b,-a);
        else{
            ans=Sum(-a,-b);
            ans=(-ans);
        }
        return ans;            
    }
    public int Sum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
    public int Subtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
}