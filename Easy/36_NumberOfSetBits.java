public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       return Approach1(n);
    }
    private int Approach1(int n){
        int sum = 0;
        while (n != 0) {
            sum++;
            // System.out.println(Integer.toBinaryString(n));
            // System.out.println(Integer.toBinaryString(n-1));
            //     System.out.println(n+" "+(n-1));
            n &= (n - 1);
        }
        return sum;
    }
    private int Approach2(int n){
        int count = 0;
        boolean flag = false;
        if(n < 0){
            flag = true;
            n = ~n;
        }
        while(n != 0){
            //System.out.println(n);
            if((n & 1) == 1){
                count ++;
            }
            n = n >> 1;
        }
        if(flag){
            count = 32 - count;
        }
        return count;
    }
}