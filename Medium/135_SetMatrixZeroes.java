class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> zeroList=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    zeroList.add(new Pair(i,j));
            }
        }
        for(Pair p:zeroList){
            for(int i=0;i<matrix.length;i++)
                matrix[i][p.j]=0;
            for(int j=0;j<matrix[0].length;j++)
                matrix[p.i][j]=0;
        }
    }
}