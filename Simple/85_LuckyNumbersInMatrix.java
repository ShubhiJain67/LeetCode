class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int minRow[]=new int[n];
        int maxCol[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]>maxCol[j])
                    maxCol[j]=matrix[i][j];
                if(matrix[i][j]<minRow[i] || minRow[i]==0)
                    minRow[i]=matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(minRow[i]==maxCol[j])
                    ans.add(minRow[i]);
            }
        }
        return ans;
    }
}