class Solution {
    class Pair{
        int len;
        int count;
        Pair(int l,int c){
            this.len=l;
            this.count=c;
        }
    }
    public int findNumberOfLIS(int[] arr) {
        if(arr.length==0)
            return 0;
        int ans=0,n=arr.length;
        Pair dp[]=new Pair[n];
        int max=1;
        dp[0]=new Pair(1,1);
        for(int i=1;i<n;i++){
            int len=0,count=0;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    if(len<dp[j].len){
                        len=dp[j].len;
                        count=dp[j].count;
                    }
                    else if(len==dp[j].len)    
                        count+=dp[j].count;
                }
            }
            if(len==0)
                dp[i]=new Pair(1,1);
            else    
                dp[i]=new Pair(len+1,count);
            if(max<len+1)   
                max=len+1;
        }
        for(Pair p:dp)  
            if(p.len==max)  
                ans+=p.count;
        return ans;
    }
}