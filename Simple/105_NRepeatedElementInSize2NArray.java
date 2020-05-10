class Solution {
    public int repeatedNTimes(int[] A) {
        int N=A.length/2;
        Arrays.sort(A);
        if(A[N-1]==A[N-2])
            return A[N-1];
        return A[N];
    }
}
