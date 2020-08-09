class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
        int len=prices.length,nextLargest[]=new int[len];
        nextLargest[len-1]=prices[len-1];
        int max=0;
        for(int i=len-2;i>=0;i--){
            nextLargest[i]=Math.max(nextLargest[i+1],prices[i+1]);
            nextLargest[i+1]-=prices[i+1];
        }
        nextLargest[0]-=prices[0];
        for(int i=len-2;i>=0;i--)
            nextLargest[i]=Math.max(nextLargest[i+1],nextLargest[i]);
        return max(prices,nextLargest);
    }
    private int max(int[] prices,int rightAns[]){
        int ans=rightAns[0];
        for(int piv=0;piv<prices.length-1;piv++){
            int left=getMax(prices,piv);
            int right=rightAns[piv+1];
            if(ans<left+right)
                ans=left+right;
        }
        return ans;
    }
    private int getMax(int prices[],int j){
        if(j==0)
            return 0;
        int arr[]=new int[j+1];
        int ans=0;
        arr[j]=prices[j];
        for(int i=j-1;i>=0;i--){
            arr[i]=Math.max(arr[i+1],prices[i+1]);
            ans=Math.max(ans,arr[i+1]-prices[i+1]);
        }
        ans=Math.max(ans,arr[0]-prices[0]);
        return ans;
    }
}