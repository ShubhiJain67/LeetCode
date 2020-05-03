class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        int l = 0;
        while (l + 1 < nums.length && nums[l] <= nums[l + 1]) l++;
        int r = nums.length - 1;
        while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
        if (r < l) return true;
        else if (l + 1 == r) {
            int ll = l - 1 >= 0 ? nums[l - 1] : Integer.MIN_VALUE;
            int rr = r + 1 < nums.length ? nums[r + 1] : Integer.MAX_VALUE;
            return ll <= nums[r] || nums[l] <= rr;
        } else return false;
    }
}