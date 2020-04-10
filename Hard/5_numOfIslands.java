import sun.security.util.Length;

class numOfIslands{
    public static void main(String[] args) {
        System.out.println("Hello");
        int board[][]={{1,1,0,0,1,0,1},{0,0,0,1,0,0,0},{1,1,1,0,0,0,0},{1,1,1,0,0,0,0}};
        System.out.println(IslandCount(board.length, board[0].length, board));
    }

    static int dir[][]={{1,0},{0,1},{-1,0},{0,-1}}; // for 4 directions
    // static int dir[][]={{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}}; // for 8 directions

    public static int IslandCount(int ei,int ej,int [][] board){
        System.out.println("Enter in the function");
        int count=0;
        for(int i=0;i<ei;i++){
            for(int j=0;j<ej;j++){
                if(board[i][j]==1){
                    count++;
                    board[i][j]=2;
                    board=DFS(i,j,board);
                    for(int iii=0;iii<ei;iii++){
                        for(int jjj=0;jjj<ej;jjj++){
                            System.out.print(board[iii][jjj]);
                        }
                        System.out.println();
                    }
                    System.out.println("**********"+count+"********************");
                }
            }
        }
        return count;
    }

    public static int[][] DFS(int si,int sj,int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                for(int d=0;d<dir.length;d++){
                    int ii=i+dir[d][0];
                    int jj=j+dir[d][1];
                    if(!(ii>=board.length || jj>=board[0].length || ii<0 || jj<0)){
                        if(board[ii][jj]==1 && board[i][j]==2){
                            System.out.println(ii+" "+jj+" "+board[ii][jj]+" "+board[i][j]);
                            board[ii][jj]=2;
                        }
                    }
                }
            }
        }
        return board;
    }
}