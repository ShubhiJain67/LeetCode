class SnakeProblem{
    public static void main(String[] args) {
        int m=2;
        int n=3;
        int [][] board=new int[m][n];
        int [][] dir={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
        String [] dirChar={"N","S","E","W","NE","NW","SE","SW"};

        System.out.println(floodfill(0,0,m-1,n-1,board,"",dir,dirChar));
        System.out.println("---------------------------------------------");
        System.out.println(floodfillMulti(0,0,m-1,n-1,board,"",dir,dirChar));
        
    }

    public static int floodfill(int si,int sj,int ei,int ej,int [][] board,String ans,int [][] dir,String [] dirChar){
        if(si==ei && sj==ej){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        board[si][sj]=1;
        for(int dirI=0;dirI<dir.length;dirI++){
            int i=si+dir[dirI][0];
            int j=sj+dir[dirI][1];
            // System.out.println(i+" "+j);
            if(isCorrect(i,j,board)){
                count+=floodfill(i, j, ei, ej, board, dirChar[dirI]+"-"+ans, dir, dirChar);
            }

        }
        board[si][sj]=0;
        return count;
    }



    public static int floodfillMulti(int si,int sj,int ei,int ej,int [][] board,String ans,int [][] dir,String [] dirChar){
        if(si==ei && sj==ej){
            System.out.println(ans);
            return 1;
        }
        int count=0;

        board[si][sj]=1;

        for(int dirI=0;dirI<dir.length;dirI++){
            int rad=1;
            if(ei>ej) rad=ei;
            else rad= ej;
            for(int jump=1;jump<=rad;jump++){
                int i=si+dir[dirI][0]*jump;
                int j=sj+dir[dirI][1]*jump;
                // System.out.println(i+" "+j);
                if(isCorrect(i,j,board)){                    
                    count+=floodfillMulti(i, j, ei, ej, board, dirChar[dirI]+jump+"-"+ans, dir, dirChar);
                }
            }
        }

        
        board[si][sj]=0;
        return count;
    }




    public static boolean isCorrect(int i,int j,int [][] board){
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length || board[i][j]==1) return false;
        return true;
    }
}