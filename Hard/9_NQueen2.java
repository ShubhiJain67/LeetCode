class Solution {
    public int totalNQueens(int n) {
        return NQueens(n,n,0);
    }
    int row=0;
    int col=0;
    int diag=0;
    int antidiag=0;
    public int NQueens(int n,int queens,int index){
        if(queens==0){
            return 1;
        }
        int count=0;
        for(int i=index;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            if((row&(1<<r))==0 && (col&(1<<c))==0 && (diag&(1<<(c-r+n-1)))==0 && (antidiag&(1<<(r+c)))==0){
                row^=(1<<r);
                col^=(1<<c);
                diag^=(1<<(c-r+n-1));
                antidiag^=(1<<(r+c));
                count+=NQueens(n,queens-1,i+1);
                row^=(1<<r);
                col^=(1<<c);
                diag^=(1<<(c-r+n-1));
                antidiag^=(1<<(r+c));
            }
        }
        return count;
    }
}
