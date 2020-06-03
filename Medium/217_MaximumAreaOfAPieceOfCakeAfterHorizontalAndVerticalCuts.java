class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int h1 = horizontalCuts[0];
        int v1 = verticalCuts[0];
        for(int i=1;i<horizontalCuts.length;i++){
            h1 = Math.max(h1, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for(int i=1;i<verticalCuts.length;i++){
            v1 = Math.max(v1, verticalCuts[i] - verticalCuts[i-1]);
        }
        h1 = Math.max(h1, h - horizontalCuts[horizontalCuts.length-1]);
        v1 = Math.max(v1, w - verticalCuts[verticalCuts.length-1]);
        return (int)((((long)h1) * v1)%(1000000007));
    }
}