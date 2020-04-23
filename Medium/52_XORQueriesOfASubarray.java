class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] =new int[queries.length];
        int cur=0;
        for(int i=0;i<queries.length;i++){
            cur=0;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                cur=cur^arr[j];
            }
            ans[i]=cur;
        }
        return ans;
    }
}