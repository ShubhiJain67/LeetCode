class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length-1;
        int l=(n+1)/2;
        int upto=n;
        for(int i=0;i<l;i++){
            for(int j=i;upto>0 && j<i+upto;j++){
                int temp=matrix[n-j][i];
                matrix[n-j][i]=matrix[n-i][n-j];
                matrix[n-i][n-j]= matrix[j][n-i];
                matrix[j][n-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
            upto=upto-2;
        }
    }
}