class Solution {
    public int maxSubarraySumCircular(int[] A) {
       
        int sum = 0, maxSum = 0, diff = 0, minDiff = 0, totalSum = 0;
        maxSum = Arrays.stream(A).max().getAsInt(); //line 1
        minDiff = Arrays.stream(A).min().getAsInt(); //line 2
        for(int i=0;i<A.length;i++){
            totalSum += A[i];
            if(maxSum > 0){
            sum += A[i];
            sum = Math.max(sum, 0);
            maxSum = Math.max(sum, maxSum);
            }
            if(minDiff < 0){
                diff += A[i];
                diff = Math.min(diff, 0);
                minDiff = Math.min(diff, minDiff);
            }
        }
        if(totalSum == minDiff)
            return maxSum;
        return Math.max(totalSum - minDiff, maxSum);
    }
}