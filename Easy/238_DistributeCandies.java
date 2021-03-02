class Solution {
    public int distributeCandies(int[] candyType) {
        int ans = 0;
        if (candyType != null) {
            int candyTypeLen = candyType.length;
            if (candyTypeLen > 0) {
                Set<Integer> hashSet = new HashSet<Integer>();
                for (int candy : candyType) {
                    hashSet.add(candy);
                }
                int candyAllowed = candyTypeLen >> 1;
                int candyTypes = hashSet.size();
                return candyAllowed > candyTypes ? candyTypes : candyAllowed;
            }
        }
        return ans;
    }
}