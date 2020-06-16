class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        if(threshold==0 || min(arr)>threshold)
            return n-k+1;
        int sum=0;
        int count=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if((sum/k)>=threshold)
            count++;
        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            if((sum/k)>=threshold)
                count++;
        }
        return count;
    }
    private int min(int [] arr){
        int m=arr[0];
        for(int i:arr)
            if(i<m)
                m=i;
        return m;
    }
}