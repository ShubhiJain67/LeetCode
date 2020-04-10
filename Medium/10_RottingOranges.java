import java.util.*;
class RottingOranges{
    public static void main(String[] args) {
        int [][] board={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(CountTime(board));
    }

    static int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};

    public static int CountTime(int [][] board){
        int rowCount=board.length;
        int colCount=board.length;
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < rowCount; ++r){
            for (int c = 0; c < colCount; ++c){
                if (board[r][c] == 2) {
                    int code = r * colCount + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
                
        }
            
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / colCount, c = code % colCount;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if (0 <= nr && nr < rowCount && 0 <= nc && nc < colCount && board[nr][nc] == 1) {
                    board[nr][nc] = 2;
                    int ncode = nr * colCount + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        
        for (int[] row: board)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;
    }
}