class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                board[i][0]='#';
                board=DFS(board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                board[i][board[0].length-1]='#';
                board=DFS(board,i,board[0].length-1);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                board[0][i]='#';
                board=DFS(board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                board[board.length-1][i]='#';
                board=DFS(board,board.length-1,i);
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    public int [][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public char[][] DFS(char[][] board ,int i,int j){
        for(int d=0;d<dir.length;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            if(r<board.length && r>=0 && c<board[0].length && c>=0  && board[r][c]=='O'){
                board[r][c]='#';
                board=DFS(board,r,c);
            }
        }
        return board;
    }
}