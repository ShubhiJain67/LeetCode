class Solution {
    public boolean canArrange(int[] arr, int k) {
        int count[]=new int[k];
        int len=arr.length;
        for(int i=0;i<len;i++){
            arr[i]=arr[i]%k;
            if(arr[i]<0)
                arr[i]=arr[i]+k;
            count[arr[i]]++;
        }
        // for(int c:count)
        //     System.out.print(c+" ");
        if(count[0]%2!=0)
            return false;
        int i=1,j=k-1;
        while(i<j){
            if(count[i]!=count[j])
                return false;
            i++;
            j--;
        }
        if(i==j)
            if(count[i]%2!=0)
                return false;
        return true;
    }
}