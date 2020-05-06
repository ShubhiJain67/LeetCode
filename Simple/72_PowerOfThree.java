public class Solution {
    public boolean isPowerOfThree(int n) {
        System.out.println(Integer.toString(n, 3));
        return Integer.toString(n, 3).matches("^10*$");
    }
}