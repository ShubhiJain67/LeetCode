class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[256];
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            map[p.charAt(i)]++;
        }
        List<Integer> ret = new ArrayList();
        int found = 0, begin = 0, end = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0)
                found++;
            while (found == pLen) {
                if (end - begin == pLen) {
                    ret.add(begin);
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    found--;
                }
            }
        }
        return ret;
    }
}