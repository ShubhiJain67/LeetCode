class Solution {
        
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int ans=0;
        for(int i=0;i<board.length*board[0].length;i++){
            int r=i/m;
            int c=i%m;
            if(board[r][c]=='X'){
                board[r][c]='.';
                ans++;
                alter(board,r,c);
            }
        }
        return ans;
    }
    public void alter(char[][] board,int r,int c){
        int i=r+1;
        while(i<board.length && board[i][c]=='X'){
            board[i++][c]='.';
        }
        int j=c+1;
        while(j<board[0].length && board[r][j]=='X'){
            board[r][j++]='.';
        }
    }
}