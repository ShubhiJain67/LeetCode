class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        int[][] board = new int[8][8];
        int rows = queens.length;
        for(int i=0;i<rows;i++)
            board[queens[i][0]][queens[i][1]] = -1;
        List<List<Integer>> answer = new ArrayList<>();
        int[][] directions = { {0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        
        for(int i=0;i<8;i++)
        {
            int x = king[0];
            int y = king[1];
            while(x>=0 && y>=0 && x<8 && y<8)
            {
                if(board[x][y] == -1)
                {
                    answer.add(new ArrayList<>(Arrays.asList(x,y)));
                    break;
                }
                x = x + directions[i][0];
                y = y + directions[i][1];
            }
        }
        return answer;
    }
}