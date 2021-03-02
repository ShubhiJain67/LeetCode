class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        int totalRows = accounts.length;
        if (totalRows != 0){
            int totalColumns = accounts[0].length;
            if (totalColumns != 0){
                for(int currRow = 0; currRow < totalRows; currRow++){
                    int currSum = 0;
                    for(int currColumn = 0; currColumn < totalColumns; currColumn++){
                        currSum += accounts[currRow][currColumn];
                    }
                    if (maxSum < currSum){
                        maxSum = currSum;
                    }
                }
            }
        }
        return maxSum;
    }
}