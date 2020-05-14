class Solution {
  boolean[][] row = new boolean[9][9];
  boolean[][] col = new boolean[9][9];
  boolean[][] box = new boolean[9][9];
  
  public void solveSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != '.') {
          int p = board[i][j] - 49;
          row[i][p] = true;
          col[j][p] = true;
          box[i / 3 * 3 + j / 3][p] = true;
        }
      }
    }
    solve(board, 0, 0);
  }

  boolean solve(char[][] board, int i, int j) {
    if (i == board.length) return true;
    if (j == board.length) return solve(board, i+1, 0);

    if (board[i][j] != '.') return solve(board, i, j+1);

    int m = i / 3 * 3 + j / 3; // boxes array index
    for (int k = 0; k < 9; k++) {
      if (!row[i][k] && !col[j][k] && !box[m][k]) {
        row[i][k] = true;
        col[j][k] = true;
        box[m][k] = true;
        board[i][j] = (char) (k + 49);

        if (solve(board, i, j+1))
          return true;

        board[i][j] = '.';
        row[i][k] = false;
        col[j][k] = false;
        box[m][k] = false;
      }
    }
    return false;
  }
}