class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        back(0, n, res);
        return res;
    }
    public void back(int cur, int n, List<Integer> res) {
        for (int i = 0; i < 10; i++) {
            if (cur == 0 && i == 0) continue;
            cur *= 10;
            cur += i;
            if (cur <= n) {
                res.add(cur);
                back(cur, n, res);
            }
            cur /= 10;
        }
    }
}