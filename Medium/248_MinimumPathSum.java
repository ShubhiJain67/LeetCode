public class MinPathSum {
    public static void main(String[] args) {
        int maze[][]={{1,2,3,4,5},{2,3,4,5,6},{7,6,5,4,3},{1,2,3,4,5}};
        int n=maze.length,m=maze[0].length;
        memo=new int[n][m];
        System.out.println(minPath(maze, 0, 0, n-1, m-1));
        System.out.println(minPathMemo(maze, 0, 0, n-1, m-1));
        System.out.println(minPathDP(maze));
    }
    private static int minPath(int maze[][],int si,int sj,int ti,int tj){
        if(si==ti && sj==tj)
            return maze[ti][tj];
        if(si>=maze.length || sj>=maze[0].length)
            return Integer.MAX_VALUE;
        int left=minPath(maze,si,sj+1,ti,tj);
        int right=minPath(maze,si+1,sj,ti,tj);
        return Math.min(left,right)+maze[si][sj];
    }
    private static int memo[][];
    private static int minPathMemo(int maze[][],int si,int sj,int ti,int tj){
        if(si==ti && sj==tj)
            return maze[ti][tj];
        if(si>=maze.length || sj>=maze[0].length)
            return Integer.MAX_VALUE;
        if(memo[si][sj]!=0)
            return memo[si][sj];
        int left=minPathMemo(maze,si,sj+1,ti,tj);
        int right=minPathMemo(maze,si+1,sj,ti,tj);
        memo[si][sj]=Math.min(left,right)+maze[si][sj];
        return memo[si][sj];
    }
    private static int minPathDP(int maze[][]){
        int n=maze.length,m=maze[0].length;
        int dp[][]=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i+1<n && j+1<m)
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1]);
                else if(i+1<n)
                    dp[i][j]+=dp[i+1][j];
                else if(j+1<m)
                    dp[i][j]+=dp[i][j+1];
                dp[i][j]+=maze[i][j];
            }
        }
        return memo[0][0];
    }
}
