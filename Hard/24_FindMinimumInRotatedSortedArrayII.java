public class Solution {

    public int findMin(int[] num) {
        return _findMin(num, 0, num.length - 1);
    }

    private int _findMin(int[] num, int start, int end) {
        if (num[start] < num[end]) {
            return num[start];
        }

        if (start == end) {
            return num[end];
        }

        if (start + 1 == end) {
            return num[end];
        }

        int mid = (end + start) / 2;
        if (num[mid] < num[start]) {
            return _findMin(num, start, mid);
        } else if (num[mid] > num[start]) {
            return _findMin(num, mid, end);
        } else {
            return _findMin(num, start + 1, end);
        }
    }
}