class Solution {
     public String convert(String s, int numRows) {
         int col=s.length()/numRows
         char trans[][]=new char[numRows][];
         String result="";
         int ss=0;
         if(s.length()==0 || s.length()==1 || numRows==1){
             return s;
         }
         for(int i=0;i<s.length() && ss!=s.length();i++){
             for(int j=0;j<numRows && ss!=s.length();j++){
                 if(i%(numRows-1)==0 || (i+j)%(numRows-1)==0){
                     trans[j][i]=s.charAt(ss);
                     ss++;
                 }
             }
         }
         for(int i=0;i<numRows;i++){
             for(int j=0;j<s.length() ;j++){
                 if(trans[i][j]!='\u0000'){
                     // System.out.print(trans[i][j]);
                     result+=trans[i][j];
                 }
             }
             // System.out.println();
         }
         return result;
     }
}