class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            if(check(i,0,matrix)==false)
                return false;
        }
        for(int i=1;i<matrix[0].length;i++){
            if(check(0,i,matrix)==false)
                return false;
        }
        return true;
    }
    private boolean check(int i,int j,int [][] matrix){
        int num=matrix[i][j];
        while(i<matrix.length && j<matrix[0].length){
            // System.out.print(i+" "+j+" -> ");
            if(matrix[i][j]!=num)
                return false;
            i++;
            j++;
        }
        return true;
    }
}