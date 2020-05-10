class Solution {
    class Pair{
        int num;
        int index;
        Pair(int n,int i){
            this.num=n;
            this.index=i;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        Pair[] arr=new Pair[n];
        for(int i=0;i<n;i++){
            int num=get(mat[i],m);
            arr[i]=new Pair(num,i);
        }
        Arrays.sort(arr,(Pair a,Pair b)->{
            return a.num-b.num;
        });
        int [] ans=new int[k];
        for(int i=1;i<=k;i++){
            ans[i-1]=arr[i-1].index;
        }
        return ans;
    }
    public int get(int [] ar,int m){
        int i=0;
        int j=m-1;
        while(i<j){
            int mid=(i+j)/2;
            if(ar[mid]==1 && ar[mid+1]==0) return mid+1;
            if(ar[mid]==0) j=mid-1;
            else i=mid+1;
        }
        if(i==0){
            return ar[i]==0?0:1;
        }
        return i+1;
    }
}