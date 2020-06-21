class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if(n==0)    return 0;
        int m=matrix[0].length;
        if(m==0)    return 0;
        
        int mat[]=new int[m];
        for(int j=0;j<m;j++)    mat[j]=matrix[0][j]-'0';
        
        int ans=largestRectangleArea(mat);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++)
                mat[j]=(matrix[i][j]=='0')?0:mat[j]+matrix[i][j]-'0';
            int ret=largestRectangleArea(mat);
            ans=Math.max(ans,ret);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==0) return 0;
        int stack[]=new int[len+1],top=0,ans=0;
        stack[0]=-1;
        for(int i=0;i<len;i++){
            while(stack[top]!=-1 && heights[stack[top]]>=heights[i]){
                ans=Math.max(ans,heights[stack[top]]*(i-stack[top-1]-1));
                top--;
            }
            stack[++top]=i;
        }
        while(stack[top]!=-1){
            ans=Math.max(ans,heights[stack[top]]*(len-stack[top-1]-1));
            top--;
        }
        return ans;
    }
}