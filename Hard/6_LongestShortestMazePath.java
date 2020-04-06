class LongestMazePath{
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int [][] board=new int[m][n];
        // System.out.println(height(0,0,board));
        System.out.println(LongestLengthPathSingleChar(0,0,board));
        Pair ans=LongestLengthPathMultiChar(0,0,board);
        System.out.println(ans.len+" "+ans.str);
        
    }
    static int [][] dir={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
    static String [] dirChar={"N","S","E","W","A","B","C","D"};
    static String [] dirCh={"N","S","E","W","NE","NW","SE","SW"};
    // here all the characters are of one length therefore LongestLengthPath is working
    public static int height(int si,int sj,int [][] board){
        if(si==board.length && sj==board[0].length){
            return 0;
        }
        int max=0;
        board[si][sj]=1;
        for(int d=0;d<dir.length;d++){
            int ii=si+dir[d][0];
            int jj=sj+dir[d][1];
            if(isValid(ii,jj,board)){
                int len=1+height(ii,jj,board);
                // System.out.println(len);
                if(max<len+1){
                    max=len;
                }
            }
        }
        board[si][sj]=0;
        return max;
    }

    public static boolean isValid(int i,int j,int [][] board){
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length || board[i][j]==1) return false;
        
        return true;
    }

    public static String LongestLengthPathSingleChar(int si,int sj,int [][] board){
        if(si==board.length && sj==board[0].length){
            return "";
        }
        String max="";
        board[si][sj]=1;
        for(int d=0;d<dir.length;d++){
            int ii=si+dir[d][0];
            int jj=sj+dir[d][1];
            if(isValid(ii,jj,board)){
                String RecStr=dirChar[d]+"-"+LongestLengthPathSingleChar(ii,jj,board);
                // System.out.println(len);
                if(max.length()<RecStr.length()){
                    max=RecStr;
                }
            }
        }
        board[si][sj]=0;
        return max;
    }



    static class Pair{
        int len;
        String str;
        Pair(int l,String s){
            len=l;
            str=s;
        }
    }

    public static Pair LongestLengthPathMultiChar(int si,int sj,int [][] board){
        if(si==board.length && sj==board[0].length){
            return new Pair(0,"");
        }
        Pair max=new Pair(0,"");
        board[si][sj]=1;
        for(int d=0;d<dir.length;d++){
            int ii=si+dir[d][0];
            int jj=sj+dir[d][1];
            if(isValid(ii,jj,board)){
                Pair RecStr=LongestLengthPathMultiChar(ii,jj,board);
                if(max.len<RecStr.len+1){
                    max.len=RecStr.len+1;
                    max.str=dirCh[d]+"-"+RecStr.str;
                }
            }
        }
        board[si][sj]=0;
        return max;
    }
}