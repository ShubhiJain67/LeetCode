class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len=A.length;
        if(len<3) return 0;
        int max=0;
        for(int i=0;i<len;i++)
            if(A[max]<A[i])
                max=i;
        
        return max;
    }
}