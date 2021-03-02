class Solution {
    public int numIdenticalPairs(int[] nums) {
        return Approach2(nums);
    }

    public int Approach1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        int count = 0;
        for (int k : map.keySet())
            count += get(map.get(k));
        return count;
    }

    private int get(int n) {
        int ans = 0;
        while (n != 1) {
            ans += (n - 1);
            n--;
        }
        return ans;
    }

    public int Approach2(int[] nums) {
        int count = 0;
        int numCount = nums.length;
        if (numCount > 0) {
            int hashMap[] = new int[100];
            int sumTracker[] = new int[100];
            for (int num : nums) {
                hashMap[num - 1]++;
                sumTracker[num - 1] = sumTracker[num - 1] + hashMap[num - 1] - 1;
            }
            for (int sum : sumTracker) {
                count += sum;
            }
        }
        return count;
    }
}