public class Solution {
    // you need to treat n as an unsigned value
   public int hammingWeight(int n) {
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

}