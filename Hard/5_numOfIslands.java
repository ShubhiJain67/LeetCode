class numOfIslands{
    public static void main(String[] args) {
        int ei=2;
        int ej=3;
        System.out.println("Hello");
        int board[][]={{1,1,0,0,1,0,1},{0,1,1,1,0,1,0},{1,1,1,0,0,0,0},{1,1,1,0,0,0,0}};
        IslandCount(ei, ej, board);
    }

    public static boolean isValid(int i,int j,int ei,int ej){
        if(i<0 || j<0 || i>=ei || j>=ej) return false;
        return true;
    }

    public static boolean Any2Around(int i,int j,int ei,int ej,int [][]board){
        int [][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        for(int d=0;d<4;d++){
            int ii=i+dir[d][0];
            int jj=j+dir[d][1];
            if(isValid(ii,jj,ei,ej)){
                if(board[ii][jj]==2){
                    return true;
                }
            }
        }
        return false;
    }

    public static int IslandCount(int ei,int ej,int [][] board){
        System.out.println("Enter in the function");
        int count=0;
        boolean flag=false;
        for(int i=0;i<ei;i++){
            for(int j=0;j<ej;j++){
                if(board[i][j]==1){
                    cout++;
                    board[i][j]=2;
                    board=DFS(i,j,board);
                }
            }
        }
        return count;
    }

    public static int[][] DFS(int ei,int ej,int [][] board){
        for(int i=ei;i<board.length;i++){
            for(int j=ej;j<board[0].length;i++){
                
            }
        }
    }
}