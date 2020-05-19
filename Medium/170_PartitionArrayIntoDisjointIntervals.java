class Solution {
    public int partitionDisjoint(int[] A) {
        int len=A.length;
        if(len==0 || len==1) return -1;
        int [] min=new int[len];
        int [] max=new int[len];
        max[0]=A[0];
        for(int i=1;i<len;i++){
            max[i]=Math.max(A[i],max[i-1]);                
        }
        min[len-1]=A[len-1];
        for(int i=len-2;i>=0;i--){
            min[i]=Math.min(min[i+1],A[i]);
        }
        int ans=-1;
        for(int i=0;i<len-1;i++){
            if(max[i]<=min[i+1]){
                ans=i+1;
                break;
            }
        }
        return ans;
    }
}