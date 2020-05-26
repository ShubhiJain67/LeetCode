class Solution {
    public int heightChecker(int[] heights) {
        int [] helper=new int[heights.length];
        int in=0;
        for(int i:heights){
            helper[in++]=i;
        }
        Arrays.sort(helper);
        int ans=0;
        for(int i=0;i<helper.length;i++){
            if(heights[i]!=helper[i]){
                ans++;
            }
        }
        return ans;
    }
}