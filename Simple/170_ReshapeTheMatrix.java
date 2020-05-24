class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length, n=nums[0].length;
        if(r*c!=m*n || (m==r && n==c))
            return nums;
        int [][] arr=new int[r][c];
        int index=0;
        while(index<m*n){
            arr[index/c][index%c]=nums[index/n][index%n];
            index++;
        }
        return arr;
    }
}