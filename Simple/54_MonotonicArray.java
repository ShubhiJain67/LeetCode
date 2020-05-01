class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length==0 || A.length==1) return true;
        int i=0;
        while(i!=A.length-1 && A[i]==A[i+1]){
                i++;
        }
        if(i==A.length-1) return true;
        boolean flag=A[i]>A[i+1]?false:true;
        for(;i<A.length-1;i++){
            if(flag==true){
                if(A[i]>A[i+1]) return false;
            }
            else{
                if(A[i]<A[i+1]) return false;
            }
        }
        return true;
    }
}