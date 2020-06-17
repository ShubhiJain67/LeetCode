class Solution {
    public int[] finalPrices(int[] prices) {
        int len=prices.length;
        int stack[]=new int[len];
        int top=-1;
        for(int i=0;i<len;i++){
            int curr=prices[i];
            while(top!=-1 && curr<=prices[stack[top]]){
                prices[stack[top]]-=curr;
                top--;
            }
            stack[++top]=i;
        }
        return prices;
    }
}