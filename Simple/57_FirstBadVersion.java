/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        var start = 1;
        var end = n;
        while (start < end) {
            var p = start + (end - start) / 2;
            if (!isBadVersion(p)) {
                start = p + 1;
            } else {
                end = p;
            }
        }
        return start;   
    }
}