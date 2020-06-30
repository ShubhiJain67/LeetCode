class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp=new int[nums1.length][nums2.length];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        int ret= maxDot(nums1,nums2,0,0);
        return ret;
    }
    int [][] dp;
    int MAX=Integer.MIN_VALUE;
    public int maxDot(int [] nums1,int []nums2,int i,int j){
        if(i==nums1.length || j==nums2.length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a=nums1[i]*nums2[j]+maxDot(nums1,nums2,i+1,j+1);
        int b=maxDot(nums1,nums2,i,j+1);
        int c=maxDot(nums1,nums2,i+1,j);
        dp[i][j]=Math.max(a,Math.max(b,c));
        return dp[i][j];
    }
}
