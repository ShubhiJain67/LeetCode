class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[] = { 0, 0 };
        if (nums != null) {
            int n = nums.length;
            int tempArr[] = new int[n];
            if (n > 0) {
                for (int num : nums) {
                    tempArr[num - 1]++;
                }
                for (int i = 0; i < n; i++) {
                    if (tempArr[i] == 0) {
                        ans[1] = i + 1;
                    }
                    if (tempArr[i] == 2) {
                        ans[0] = i + 1;
                    }
                }
            }
        }
        return ans;
    }
}