class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        return Approach2(nums);
    }

    public int[] Approach1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[i] > nums[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public int[] Approach2(int[] nums) {
        if (nums != null) {
            int numsLength = nums.length;
            int[] ans = new int[numsLength];
            if (numsLength > 0) {
                int maxLen = 101;
                int hashMap[] = new int[maxLen];
                int sum[] = new int[maxLen];
                for (int num : nums) {
                    hashMap[num]++;
                }
                for (int hashNum = 1; hashNum < maxLen; hashNum++) {
                    sum[hashNum] = sum[hashNum - 1] + hashMap[hashNum - 1];
                }
                for (int hashNum = 0; hashNum < numsLength; hashNum++) {
                    ans[hashNum] = sum[nums[hashNum]];
                }
            }
            return ans;
        }
        return null;
    }
}