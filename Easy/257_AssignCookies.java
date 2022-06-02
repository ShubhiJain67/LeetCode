class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = g.length - 1;
        int sp = s.length - 1;
        while(gp >= 0 && sp >= 0){
            if(g[gp] <= s[sp]){
                count ++;
                sp--;
            }
            gp--;
        }
        return count;
    }
}