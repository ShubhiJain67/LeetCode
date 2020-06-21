//  APPROACH 1 O(3n)
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int len=heights.length;
//         if(len==0)
//             return 0;
//         int nextSmallest[]=new int[len];
//         int prevSmallest[]=new int[len];
//         int stack[]=new int[len];
//         int top=-1;
//         for(int i=0;i<len;i++){
//             while(top!=-1 && heights[stack[top]]>=heights[i])
//                 top--;
//             prevSmallest[i]=top==-1?-1:stack[top];
//             stack[++top]=i;
//         }
//         top=-1;
//         for(int i=len-1;i>=0;i--){
//             while(top!=-1 && heights[stack[top]]>=heights[i])
//                 top--;
//             nextSmallest[i]=top==-1?len:stack[top];
//             stack[++top]=i;
//         }
//         int ans=0;
//         for(int i=0;i<len;i++)
//             ans=Math.max(ans,(nextSmallest[i]-prevSmallest[i]-1)*heights[i]);
//         return ans;
//     }
// }
//  APPROACH 2 O(2n)
class Solution {
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