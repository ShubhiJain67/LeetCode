import java.util.*;
class NQueen1 {
    
    public static void main(String args[]){
       solveNQueens(12);
    }
        static ArrayList<String> ansList=new ArrayList<>();
        public static List<List<String>> solveNQueens(int n) {
            NQueens(n,n,0,"");
            List<List<String>> finalans=new ArrayList<>();
            for(String s: ansList){
                String[] str = s.split(":");
                List<String> strlist=new ArrayList<>();
                for(String ss:str){
                    String[] sub=ss.split(",");
                    
                    int a=0;
                    int b=0;
                    for(int j=0;j<sub[0].length();j++){
                        a=a*10+(sub[0].charAt(j)-'0');
                    }
                    for(int j=0;j<sub[1].length();j++){
                        b=b*10+(sub[1].charAt(j)-'0');
                    }
                    String substr="";
                    for(int loop=0;loop<n;loop++){
                        if(loop==b){
                            substr=substr+"Q";
                        }
                        else{
                            substr=substr+".";
                        }
                    }
                    System.out.println(a+","+b+" | "+substr);
                    strlist.add(substr);
                }
                finalans.add(strlist);
                System.out.println("******************************************");
            }
            return finalans;
            
        }
        static int row=0;
        static int col=0;
        static int diag=0;
        static int antidiag=0;
        public static void NQueens(int n,int queens,int index,String ans){
            if(queens==0){
                // System.out.println(ans);
                ansList.add(ans);
                return ;
            }
            for(int i=index;i<n*n;i++){
                int r=i/n;
                int c=i%n;
                if((row&(1<<r))==0 && (col&(1<<c))==0 && (diag&(1<<(c-r+n-1)))==0 && (antidiag&(1<<(r+c)))==0){
                    row^=(1<<r);
                    col^=(1<<c);
                    diag^=(1<<(c-r+n-1));
                    antidiag^=(1<<(r+c));
                    NQueens(n,queens-1,i+1,ans+r+","+c+":");
                    row^=(1<<r);
                    col^=(1<<c);
                    diag^=(1<<(c-r+n-1));
                    antidiag^=(1<<(r+c));
                    
                }
            }
            
        }
    }
