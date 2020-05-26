class Solution {
    public boolean isPowerOfFour(int n)
    {
        if (n > 0 && (n & (n - 1))==0) // is num power of 2
        {
            int count = 0;  // count of all zeros after 1.
            while (n > 1)
            {
                count++;
                n >>= 1;
            }

            if ((count & 1) == 0)
                return true; // count of zeros after 1 should be a even number.
        }

        return false;
    }
}