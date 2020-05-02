class Solution {
     public boolean exist(char[][] board, String word) {
        for(int  i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(back(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
            
    public boolean back(int i, int j, int pos, char[][] board, String word){
        
        if(  word.charAt(pos) != board[i][j] )    return false;
        
        if( pos == word.length() -1 ) return true;  
        
        char ch = board[i][j];
        board[i][j] = '0';
        if(
            ( i-1 >= 0 && back(i-1, j, pos+1, board, word)) || 
            ( j-1 >= 0 && back(i, j-1, pos+1, board, word)) ||
            ( i+1 < board.length && back(i+1, j, pos+1, board, word)) || 
            ( j+1 < board[i].length && back(i, j+1, pos+1, board, word))
          )     
            return true;
         board[i][j] = ch;
        
        return false;
    } 
}