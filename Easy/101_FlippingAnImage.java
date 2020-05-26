class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len=A.length;
        if(len==0) return A;
        for(int i=0;i<len;i++){
            int start=0;
            int end=A[i].length-1;
            while(start<=end){
                if(A[i][start]!=A[i][end]){
                }
                else{
                    A[i][start]=(A[i][start]==0?1:0);
                    A[i][end]=A[i][start];
                }
                start++;
                end--;
            }
        }
        return A;
    }
}